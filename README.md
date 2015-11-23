# TelebotSlaveArms
Telebot Slave Arms Component

##Installation

###Git
`git clone --recursive https://github.com/FIUDiscoveryLab/TelebotSlaveArms.git`

###Eclipse IDE

### Common Issues

#### JRE System Library is not set
-Right-click on project
-In the "Java Build Path" menu select the "Libraries" tab
-Click on the "Add Library" button
-Choose "JRE System Library"
-Workspace default JRE (...)

#### "The declare package does not match the expected package"

-Right-click in the projects "src" folder
-Select "Build Path / Use as source folder"

#### Linux - Ubuntu 64x
1. Set java path
..*Right click on the project -> properties -> set java build path
2. set environment variable
..1Right click Java which contains main class -> Run As -> Run Configurations -> Environments (tab)
..2Click on New button
..3 Name: `LD_LIBRARY_PATH`  , VALUE: `${project_loc}/ThirdParty/ndds.5.1.0/lib/x64Linux2.6gcc4.4.5jdk`

#### Linux - Ubuntu 32x
1. Set java path
..*Right click on the project -> properties -> set java build path
2. set environment variable
..1Right click Java which contains main class -> Run As -> Run Configurations -> Environments (tab)
..2Click on New button
..3 Name: `LD_LIBRARY_PATH` , VALUE: `${project_loc}/ThirdParty/ndds.5.1.0/lib/i86Linux2.6gcc4.4.5jdk`

#### Windows 64x
1. Set java path
..*Right click on the project -> properties -> set java build path
2. set environment variable
..1Right click Java which contains main class -> Run As -> Run Configurations -> Environments (tab)
..2Click on New button
..3 Name: `PATH`  , VALUE: `${project_loc}\ThirdParty\ndds.5.1.0\lib\x64Win64jdk`
