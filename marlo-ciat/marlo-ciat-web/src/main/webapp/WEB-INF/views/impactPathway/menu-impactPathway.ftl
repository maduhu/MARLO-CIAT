[#ftl]
[#assign items= [
  { 'slug': 'programImpacts',           'name': 'impactPathway.menu.hrefProgramImpacts',  'action': 'programimpacts',           'active': true  },
  { 'slug': 'researchTopics',  'name': 'impactPathway.menu.hrefResearchTopics',       'action': 'researchTopics',  'active': true },
  { 'slug': 'outcomes',           'name': 'impactPathway.menu.hrefOutcomes',  'action': 'outcomesList',           'active': true  },
  { 'slug': 'outputs',  'name': 'impactPathway.menu.hrefOutputs',       'action': 'outputsList',  'active': true }
]/]


[#attempt]
  [#assign submission = (action.isSubmitIP(programID))! /]
  [#assign canSubmit = (action. hasPersmissionSubmitIP(programID))!false /]
  [#assign completed = (action.isCompleteIP(programId))!false /]
[#recover]
  [#assign submission = false /]
  [#assign canSubmit = false /]
  [#assign completed = false /]
[/#attempt]

[#assign sectionsForChecking = [] /]

<link rel="stylesheet" href="${baseUrl}/css/global/impactGraphic.css" />


<nav id="secondaryMenu" class="">
  <p>[@s.text name="impactPathway.menu.title"/]</p>
  <ul>
    <li>
      <ul>
        [#list items as item]
          [#assign submitStatus = (action.getprogramSectionStatus(item.action, programID))!false /]
          <li id="menu-${item.action}" class="[#if item.slug == currentStage]currentSection[/#if] [#if canEdit]${submitStatus?string('submitted','toSubmit')}[/#if] ${(item.active)?string('enabled','disabled')}">
            <a href="[@s.url action="${centerSession}/${item.action}"][@s.param name="programID" value=programID /][@s.param name="edit" value="true"/][/@s.url]" onclick="return ${item.active?string}">
              [#if item.slug == "outcomes"]
                  <span class="glyphicon glyphicon-chevron-right"></span>
              [#elseif item.slug == "outputs"]
                  &nbsp; <span class="glyphicon glyphicon-chevron-right"></span>
              [/#if]
              [@s.text name=item.name/]
            </a>
          </li>
          [#if item.active]
              [#assign sectionsForChecking = sectionsForChecking + ["${item.action}"] /]
            [/#if]
        [/#list] 
      </ul>
    </li>
  </ul> 
</nav>

<div class="clearfix"></div>

[#-- Sections for checking (Using by JS) --]
<span id="sectionsForChecking" style="display:none">[#list sectionsForChecking as item]${item}[#if item_has_next],[/#if][/#list]</span>

[#-- Submition message --]
[#if !submission?has_content && completed && !canSubmit]
  <p class="text-center" style="display:block">The Program can be submitted now.</p>
[/#if]

[#-- Check button --]
[#if canEdit && !completed && !submission?has_content]
  <p class="programValidateButton-message text-center">Check for missing fields.<br /></p>
  <div id="validateProgram-${programID}" class="projectValidateButton">[@s.text name="form.buttons.check" /]</div>
  <div id="progressbar-${programID}" class="progressbar" style="display:none"></div>
[/#if]

[#-- Submit button --]
[#if canEdit]
  [#assign showSubmit=(canSubmit && !submission?has_content && completed)]
  <a id="submitProgram-${programID}" class="projectSubmitButton" style="display:${showSubmit?string('block','none')}" href="[@s.url action="${centerSession}/submit"][@s.param name='programID']${programID}[/@s.param][/@s.url]" >
    [@s.text name="form.buttons.submit" /]
  </a>
[/#if]


[#-- Mini-graph --]
<div id="graphicWrapper">
<p class="text-center"><b>Impact Pathway Graph</b></p>
  <div id="mini-graphic">
    <div id="overlay" >
      <button class="btn btn-primary btn-xs"><strong>Show graph</strong></button>
    </div>
  </div>
  <div class="clearfix"></div>
</div>

[#-- PopUp Graph --]
<div id="impactGraphic-content"  style="display:none;" >
  
  [#-- Information panel --]
  <div id="infoRelations" class="panel panel-default">
    <div class="panel-heading"><strong>Relations</strong></div>
    <div id="infoContent" class="panel-body">
     <ul></ul>
    </div>
  </div>
  
  [#-- Controls --]
  <div id="controls" class="">
    <span id="zoomIn" class="glyphicon glyphicon-zoom-in tool"></span>
    <span id="zoomOut" class="glyphicon glyphicon-zoom-out tool "></span>
    <span id="panRight" class="glyphicon glyphicon-arrow-right tool "></span>
    <span id="panDown" class="glyphicon glyphicon-arrow-down tool "></span>
    <span id="panLeft" class="glyphicon glyphicon-arrow-left tool "></span>
    <span id="panUp" class="glyphicon glyphicon-arrow-up tool "></span>
    <span id="resize" class="glyphicon glyphicon-resize-full  tool"></span>
  </div>
  
  [#-- Change to full or current graph --]
  <div id="changeGraph">
  <span class="btn btn-primary btn-md currentGraph">Show graph by area</span>
  </div>
  
  [#-- Download button--]
  <a class="download" href=""><span title="download" id="buttonDownload"><span class="glyphicon glyphicon-download-alt"></span></span></a>
  
  <div id="impactGraphic"></div>
</div>


[#-- program Submit JS --]
[#assign customJS = [ "${baseUrl}/js/global/impactGraphic.js", "${baseUrl}/js/impactPathway/programSubmit.js" ] + customJS  /]