[#ftl]
[#import "/WEB-INF/global/macros/utils.ftl" as utilities/]
[#macro projectsList projects={} owned=true canValidate=false canEdit=false isPlanning=false namespace="/" defaultAction="description"]
  <table class="projectsList" id="projects">
    <thead>
      <tr class="header">
        <th id="ids">[@s.text name="projectsList.projectids" /]</th>
        <th id="projectTitles" >[@s.text name="projectsList.projectTitles" /]</th>
        <th id="projectOutputs" >[@s.text name="projectsList.projectOutputs" /]</th>
        <th id="projectContactPerson">[@s.text name="projectsList.projectFlagships" /]</th>
        <th id="projectStartDate">[@s.text name="projectsList.delete" /]</th>
        <th id="projectEndDate">[@s.text name="projectsList.delete" /]</th>
      </tr>
    </thead>
    <tbody>
    [#if projects?has_content]
      [#list projects as project]         
        [#local projectUrl][@s.url namespace=namespace action=defaultAction][@s.param name='projectID']${project.id?c}[/@s.param][@s.param name='edit' value="true" /][/@s.url][/#local]
        <tr>
        [#-- ID --]
        <td class="projectId">
          <a href="${projectUrl}"> P${project.id}</a>
        </td>
          [#-- Project Title --]
          <td class="left">
            [#if project.name?has_content]
              <a href="${projectUrl}" title="${project.name}">
              [#if project.name?length < 120] ${project.name}</a> [#else] [@utilities.wordCutter string=project.title maxPos=120 /]...</a> [/#if]
            [#else]
              <a href="${projectUrl}">
                [@s.text name="projectsList.title.none" /]
              </a>
            [/#if]
          </td>
          [#-- Project Outputs --]
          <td class=""> 
            [#if project.name?has_content]${(project.name)!"No existe"}[#else][@s.text name="projectsList.title.none" /][/#if]
          </td>
          [#-- Contact person--]
          <td>
           [#if project.contactPerson?has_content]${(project.contactPerson.composedName)!"No Existe"}[#else][@s.text name="projectsList.title.none" /][/#if]
          </td>
          [#-- start date --]
          <td>
           [#if project.startDate?has_content]${(project.startDate)!"No Existe"}[#else][@s.text name="projectsList.title.none" /][/#if]
          </td>
          [#-- end date --]
          <td>
           [#if project.endDate?has_content]${(project.endDate)!"No Existe"}[#else][@s.text name="projectsList.title.none" /][/#if]
          </td>
        </tr>  
      [/#list]
    [/#if]
    </tbody>
  </table>
[/#macro]

