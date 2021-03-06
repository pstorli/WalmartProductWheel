Name: Walmart Product Wheel

Author: Pete Storli
Date: 31 Jan 2020
Email: pstorli@gmail.com
Version "1.0.0.1"

Issues Resolved in 1.0.0.1:
  0000 Converted project to use AndroidX Jetpack
  0000 Added Expresso tests. (Also created IdlingResource due to products loading from web)

Known Issues in 1.0.0.1:
  0000 Need to replace recycler view with Jetpack ones so state is preserved when phone is rotated.

Issues Resolved in 1.0.0.0:
  0000 Inital Creation
  0000 Added product list and product detail fragments.
  0000 Added click on product in list and details for peoduct will be shown.
  0000 All UI functioning correctly.
  0000 Loading product list from url now.
  0000 Added lazy loading to product list
  0000 Adding padding to product list items
  0000 Added product image to product details
  0000 Hid short and long descriptions if text is blank.
  0000 Added routine to convert short and long text from html to span
  0000 Made product list text color red if out of stock, black if selected otherwise walmart blue
  0000 Added snackbar when product in stock button is pressed. Use red text if out of stock, in stock uses green.

Date: Initial Project Creation 13 Jan 2019 - 15 Jan 2019
Known Issues in 1.0.0.0:
  0000 When you go from the ProductDetail page to the ProductList page,
       app needs to scroll to current item, more work is needed to complete this feature.

  0000 Added code to handle onSaveInstanceState and onRestoreInstanceState
       When an onOrientation change happens, onSaveInstanceState and onRestoreInstanceState are called,
       but more work is needed to complete this feature and get the app ddata persisted. (Started)

Notes:
  See the file Overlay.pdf or goto site
  https://sites.google.com/site/storlidesignsllc/home/walmartproductwheelclassoverview

  Click here to goto the main storli designs site
  https://sites.google.com/site/storlidesignsllc/

  Click here to download the WalmartProductWheel App
  https://drive.google.com/file/d/10Q0RtaAXdXGye-4ieInskH34xZoLtW_p/view

  Click here to goto github to download the WalmartProductWheel Android Studio Project
  https://github.com/pstorli/WalmartProductWheel

  Click here to goto the walmart brands center
  https://www.walmartbrandcenter.com/downloads.aspx

  git clone git://github.com/pstorli/WalmartProductWheel.git

  git remote add origin https://github.com/pstorli/WalmartProductWheel.git
  git push -u origin master

[core]
	repositoryformatversion = 0
	filemode = true
	bare = false
	logallrefupdates = true
[remote "origin"]
	url = https://github.com/pstorli/WalmartProductWheel.git /home/pstorli/git/WalmartProductWheel
	fetch = +refs/heads/*:refs/remotes/origin/*
[branch "master"]
	remote = origin
	merge = refs/heads/master
