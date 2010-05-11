Product: eDairy Manager Desktop 1.0
Author: SUN
Date: May 09, 2010
Summary: This guide covers all details/steps to modify the installer for the above product. Also the installation details to install product. 



Step 1 - Download installer software
====================================
Download and install "Advanced Installer". Here is the direct URL for the same, "http://www.advancedinstaller.com/downloads/advinst.msi".


Step 2 - Prepare required directory structure
=============================================
Create following directory structure on wondows pc,

=> C:\DairyManager\product - holds ur exported RCP product.
export RCP project in this directory. So that it will have configuration, plugins, edairymgr.exe, etc directly under this.

=> C:\DairyManager\installer - holds the setup installer and its configuration.
extract the installer.zip file under C:\DairyManger to create this folder, copy setup.msi.
(setup.msi is an application installer created for the code that you sent. You may use it for demo to install the product)


Step 3 - Modify the installer
=============================
Open setupConfig.aip with "Advanced Installer". Just double click on setupConfig.aip.

=> Product Branding details and Version
These can be changed from "Product Details" tab on left pane. Once you open it, its very easy to follow. Thats why not putting all details to make this guide lengthy.

=> Application change
If there is a change in your application code, you should be updating required plugins and build the installer again.
Open the "Files and Folders" tab from the left pane. On right side you should be able to see Folders tree. Expand upto following hierarchy,
Target Computer -> Application Folder -> plugins.
Modify, add/remove plugins from this by right clicking on the plugin list.

Once done with modification,
Save the configuration with menu File -> Save or Ctrl+S.
Build it with menu Project -> Build or F7.

This will create the updated setup.msi installer in C:\DairyManager\installer. You can distribute this "setup.msi" file to client as an installer for your app.


Step 4 - Installing product with installer
==========================================
Double click on setup.msi.
This will start the installer. Follow the steps and click Next. Pretty straight forward installation.

By default product will be installed in C:\Program Files\Agritrace Ltd\eDairy Manager Desktop.
Short cut will be placed in start menu and on Desktop.
Entries for registry will be made.
Product will also be shown in Add/Remove programs (Windows XP) or Programs and Features (Windows vista) in Control Panel. It can be uninstalled from here.
