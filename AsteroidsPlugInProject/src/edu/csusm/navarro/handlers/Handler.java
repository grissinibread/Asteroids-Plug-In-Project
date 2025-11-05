package edu.csusm.navarro.handlers;

import edu.csusm.navarro.clock.IClockFactory;
import edu.csusm.navarro.tech.Game;
import edu.csusm.navarro.vector.IVectorFactory;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

public final class Handler extends AbstractHandler {

    // Prevent instantiation, as this is a static utility class.
    public Handler() {} 

    // --- Clock Factory Loader ---

    public static IClockFactory loadClockFactory() {
        return (IClockFactory) loadFactory("edu.csusm.navarro.clock", "ClockFactory");
    }

    // --- Vector Factory Loader ---

    public static IVectorFactory loadVectorFactory() {
        return (IVectorFactory) loadFactory("edu.csusm.navarro.vector", "VectorFactory");
    }

    public static Object loadFactory(String extensionPointId, String elementName) {
        IExtensionRegistry registry = Platform.getExtensionRegistry();
        
        if (registry == null) {
            System.err.println("Error: Eclipse Platform or Extension Registry is not running.");
            return null;
        }

        try {
            // Get all configurations contributing to the specified extension point
            IConfigurationElement[] elements = registry
                .getConfigurationElementsFor(extensionPointId);

            // Iterate through the contributing elements
            for (IConfigurationElement element : elements) {
                // Check if the element name matches the one defined in the schema (e.g., <ClockFactory>)
                if (elementName.equals(element.getName())) {
                    // CreateExecutableExtension instantiates the class defined in the "class" attribute 
                    // of the XML element and casts it to Object.
                    return element.createExecutableExtension("class");
                }
            }
        } catch (CoreException e) {
            System.err.printf("FATAL: Failed to load factory for %s from extension point %s.\n", elementName, extensionPointId);
            e.printStackTrace();
        }
        
        System.err.printf("Warning: No implementation found for %s in extension point %s\n", elementName, extensionPointId);
        return null;
    }

	@Override
	public Object execute(ExecutionEvent arg0) throws ExecutionException {
	        // Since the user is interacting, we assume the platform is fully running.
	        System.out.println("--- GAME LAUNCH COMMAND EXECUTED ---"); 

	        try {
	            // 1. Load the factories using the reliable FactoryLoader utility
	            IClockFactory clockFactory = Handler.loadClockFactory(); 
	            IVectorFactory vectorFactory = Handler.loadVectorFactory();
	            
	            if (clockFactory != null && vectorFactory != null) {
	                // 2. Instantiate and start the Game with injected factories
	                Game game = new Game(clockFactory, vectorFactory);
	                
	                // IMPORTANT: Since you are now in a UI thread, you must run the 
	                // game loop in a separate thread to keep the Eclipse IDE responsive.
	                new Thread(() -> game.startGame()).start();
	                
	                System.out.println("Asteroids Game started successfully!");
	            } else {
	                // If factories are missing, show an error to the user.
	                System.err.println("FATAL: Plugin factories are missing. Cannot start game.");
	                // You might display a proper Eclipse error message here.
	            }
	        } catch (Exception e) {
	            throw new ExecutionException("Failed to launch Asteroids Game", e);
	        }

	        // Return value is required by the framework
	        return null; 
	    }
	}