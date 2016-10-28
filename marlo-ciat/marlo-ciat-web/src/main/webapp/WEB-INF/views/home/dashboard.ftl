[#ftl]
[#assign title = "Welcome to MARLO" /]
[#assign currentSectionString = "${actionName?replace('/','-')}" /]
[#assign pageLibs = ["jQuery-Timelinr","cytoscape","cytoscape-panzoom","cytoscape-qtip","qtip2","datatables.net", "datatables.net-bs"] /]
[#assign customJS = ["${baseUrl}/js/home/dashboard.js","${baseUrl}/js/global/impactGraphic.js"] /]
[#assign customCSS = ["${baseUrl}/css/home/dashboard.css","${baseUrl}/css/global/customDataTable.css"] /]
[#assign currentSection = "home" /]
[#assign breadCrumb = [
  {"label":"home", "nameSpace":"", "action":""}
]/]
[#include "/WEB-INF/global/pages/header.ftl" /]
[#include "/WEB-INF/global/pages/main-menu.ftl" /]

<section class="marlo-content">
  <div class="container">
    [#-- What do you want to do --]
    <div class="homeTitle"><b>[@s.text name="dashboard.decisionTree.title" /]</b></div>
    <div id="decisionTree" class="borderBox">
      <div id="impactPathway" class="option"><p>[@s.text name="dashboard.decisionTree.defineImpact" /]</p></div>
      <div class="clearfix"></div>
      <div class="addProjectButtons clearfix" style="display:none">
        <p class="title">[@s.text name="dashboard.decisionTree.typeProjectQuestion" /]</p>
            <a href="[@s.url namespace="/impactPathway" action='${(centerSession)!}/programimpacts'/]"><div class="impactPathway"><p>[@s.text name="dashboard.decisionTree.coreProject" /]</p></div></a>
      </div>
    </div>
</section>

[#include "/WEB-INF/global/pages/footer.ftl" /]