# Dynatrace-GenericOperations-Plugin

##Plugin is no longer in development in this repo.
##Plugin is developed within Dynatrace github organization. Please post issues and pull requests [here] (https://github.com/Dynatrace/Dynatrace-GenericOperations-Plugin)

Plugin that allows for generic operations on a pair of measures. The generic operations include addition, substraction, division and multiplication on the measure.
The plugin utilizes the Dynatrace RESTful API to retrive the data from the measures. It is a requirement to have the measures inside a dashboard, so that the data can be exported and manipulated

##Setup

In your dynatrace client, navigate to the Settings button, then navigate to the Dynatrace Server section. When the Dynatrace Server Setting dialog opens, click the plugin section, and import the .jar into the Dynatrace Server.

![Dynatrace Server Settings](http://i.imgur.com/8bXHnYf.png)

##How to use

1. Create a dashboard with the two metrics that you want to apply the generic operation to.
*Remember to save the dashboard to the Dynatrace Server*

![Dashboard](http://i.imgur.com/dL6eTEB.png)

2. Navigate to the system profile where the measures reside, navigate to the Monitors section
3. Select a GenericOperationMonitor.
4. Fill out the corresponding fields:
  - The Dynatrace Server where the measure are located
  - Username: the username that is used to access the client *make sure this user has access to the web services*
  - Password: The password for the user
  - Dashboard Name
  - The first measure
  - The second measure
  - The type of operation to perform (+, -, *, /)
![Monitor Configuration](http://i.imgur.com/2eygjLd.png)

**The plugin will automatically detect the aggregation that is set on the dashlet for the measures. Make sure to configure the dashlet with the correct aggregation (Average, Sum, Count, Maximum and Minimum) and saving before create a GenericOperation Monitor.**

I am open to ideas on improving the plugin. If you have any enhancement ideas please open an issue or contact me at jose.colella@dynatrace.com
