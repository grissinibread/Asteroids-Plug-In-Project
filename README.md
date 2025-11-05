# Asteroids Plug-In Project

The original Asteroids game contained a high level of coupling between its components.
To address this, and to better support testing of **extensions** and **extension points**, I restructured the project to decouple the Vector and Clock classes from the rest of the game logic.

This change improves modularity, makes testing easier, and allows future features or updates to be integrated with less impact on existing code.

My design can be seen in the following image:
<img width="2254" height="1804" alt="Assignment 3 - Page 1 (2)" src="https://github.com/user-attachments/assets/86dc25f8-df57-47ba-81c6-b0f191f7cf80" />

For comparison purposes, here is a link to the [original project]([url](https://github.com/PSNB92/Asteroids)).
