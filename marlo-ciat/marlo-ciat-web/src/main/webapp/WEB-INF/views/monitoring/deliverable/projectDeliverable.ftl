[#ftl]
[#assign title = "Project Deliverable" /]
[#assign currentSectionString = "project-${actionName?replace('/','-')}-${deliverableID}" /]
[#assign pageLibs = ["select2"] /]
[#assign customJS = ["${baseUrl}/js/global/fieldsValidation.js","${baseUrl}/js/global/usersManagement.js","${baseUrl}/js/deliverable/projectDeliverable.js"] /]
[#assign currentSection = "monitoring" /]
[#assign currentStage = "deliverables" /]
[#assign editable = true /]

[#assign breadCrumb = [
  {"label":"projectsList", "nameSpace":"/monitoring", "action":"${(centerSession)!}/projectList"},
  {"label":"deliverables", "nameSpace":"/monitoring", "action":"${(centerSession)!}/deliverableList"}
] /]


[#include "/WEB-INF/global/pages/header.ftl" /]
[#include "/WEB-INF/global/pages/main-menu.ftl" /]

<div class="container helpText viewMore-block">
  <div class="helpMessage infoText">
    [#-- <div  class="removeHelp"><span class="glyphicon glyphicon-remove"></span></div> --]
    <p class="col-md-10"> [@s.text name="projectDescription.help" /] </p>
  </div> 
  <div style="display:none" class="viewMore closed"></div>
</div>

<section class="container">
    <div class="row">
      [#-- Project Menu --]
      <div class="col-md-3">
        [#include "/WEB-INF/views/monitoring/project/menu-projects.ftl" /]
      </div>
      [#-- Project Section Content --]
      <div class="col-md-9">
        [#-- Section Messages --]
        [#--  --include "/WEB-INF/views/projects/messages-projects.ftl" / --]
      
        [@s.form action=actionName method="POST" enctype="multipart/form-data" cssClass=""]
          
          <h3 class="headTitle">[@s.text name="projectDescription.title" /]</h3>  
          <div id="projectDeliverable" class="borderBox">
            <div class="form-group row">  
            [#-- Deliverable title --]
              <div class="col-md-12">
                [@customForm.input name="deliverable.name" i18nkey="Title" type="text" disabled=!editable  required=true editable=editable /]
              </div>  
              [#-- deliverable tpye --]
              <div class="col-md-12">
                [@customForm.select name="deliverable.deliverableType"  i18nkey="Type" listName="deliverableTypes" keyFieldName="id"  displayFieldName="name" className="deliverableTypeSelect" value="" /]
              </div>               
            </div>
            <div class="form-group row">  
              [#-- Start Date --]
              <div class="col-md-6">
                [@customForm.input name="deliverable.startDate" i18nkey="Start date" type="text" disabled=!editable  required=true editable=editable /]
              </div> 
              [#-- End Date --]
              <div class="col-md-6">
                [@customForm.input name="deliverable.endDate" i18nkey="End date" type="text" disabled=!editable required=false editable=editable /]
              </div>
          </div>
          <label>[@s.text name="Supporting document(s)" /]</label>
          <div class="borderBox documentList" listname="deliverable.documents">
            [#if deliverable.documents?has_content]
              [#list deliverable.documents as document]
                [@documentMacro element=document name="deliverable.documents"  index=document_index isTemplate=false /]
              [/#list]
            [/#if]
            <p class="text-center inf" style="display:${(deliverable.documents?has_content)?string('none','block')}">[@s.text name="projectDescription.notFundingSource" /]</p>
          </div>
          <div class="text-right">
            <div class="button-green addDocument"><span class="glyphicon glyphicon-plus-sign"></span>[@s.text name="Add a support document" /]</div>
          </div>
      [#-- Section Buttons & hidden inputs--]
          [#include "/WEB-INF/views/monitoring/project/buttons-projects.ftl" /]
             
          [/@s.form] 
      </div>
    </div>  
</section>


[@documentMacro element={} name="project.fundingSources"  index=-1 isTemplate=true /]
  
[#include "/WEB-INF/global/pages/footer.ftl"]


[#macro documentMacro element name index=-1 isTemplate=false]
  [#assign documentCustomName = "${name}[${index}]" /]
  <div id="document-${isTemplate?string('template',(element.id)!)}" class="documents  borderBox row"  style="display:${isTemplate?string('none','block')}">
    [#if editable]<div class="removeDocument removeIcon" title="Remove document"></div>[/#if] 
    <input class="id" type="hidden" name="${documentCustomName}.id" value="${(element.id)!-1}" />
    <div class="col-md-12">
      [@customForm.input name="${documentCustomName}.link" i18nkey="Link" type="text" disabled=!editable required=false editable=editable /]
    </div>
  </div>
[/#macro]