[#ftl]
[#import "/WEB-INF/global/macros/utils.ftl" as utilities/]
[#macro deliverableList deliverables={} owned=true canValidate=false canEdit=false isPlanning=false namespace="/" defaultAction="projectDeliverable"]
  <table class="deliverablesList" id="deliverables">
    <thead>
      <tr class="header">
        <th id="ids">[@s.text name="deliverableList.deliverablesids" /]</th>
        <th id="deliverablesName" >[@s.text name="deliverableList.deliverablesName" /]</th>
        <th id="deliverablesType" >[@s.text name="deliverableList.deliverablesType" /]</th>
        <th id="deliverablesStartDate">[@s.text name="deliverableList.deliverablesStartDate" /]</th>
        <th id="deliverablesEndDate">[@s.text name="deliverableList.deliverablesEndDate" /]</th>
        <th id="deliverableDelete">[@s.text name="deliverableList.deliverablesRemove" /]</th>  
      </tr>
    </thead>
    <tbody>
    [#if deliverables?has_content]
      [#list deliverables as deliverable]         
        [#local deliverableUrl][@s.url namespace=namespace action=defaultAction][@s.param name='deliverableID']${deliverable.id?c}[/@s.param][@s.param name='edit' value="true" /][/@s.url][/#local]
        <tr>
        [#-- ID --]
        <td class="deliverableId">
          <a href="${deliverableUrl}"> P${deliverable.id}</a>
        </td>
          [#-- deliverable Title --]
          <td class="left">
            [#if deliverable.name?has_content]
              <a href="${deliverableUrl}" title="${deliverable.name}">
              [#if deliverable.name?length < 120] ${deliverable.name}</a> [#else] [@utilities.wordCutter string=deliverable.title maxPos=120 /]...</a> [/#if]
            [#else]
              <a href="${deliverableUrl}">
                [@s.text name="deliverableList.none" /]
              </a>
            [/#if]
          </td>
          [#-- deliverable type --]
          <td class=""> 
            [#if deliverable.type?has_content]
              ${(deliverable)!}
            [/#if]
          </td>
          [#-- start date --]
          <td>
           [#if deliverable.startDate?has_content]${(deliverable.startDate)!""}[#else][@s.text name="deliverableList.none" /][/#if]
          </td>
          [#-- end date --]
          <td>
           [#if deliverable.endDate?has_content]${(deliverable.endDate)!""}[#else][@s.text name="deliverableList.none" /][/#if]
          </td>
          [#-- Delete Deliverable--]
          <td class="text-center">
              <a id="removeDeliverable-${deliverable.id}" class="removeDeliverable" href="${baseUrl}/projects/${centerSession}/deleteDeliverable.do?deliverableID=${deliverable.id}" title="">
                <img src="${baseUrl}/images/global/trash.png" title="[@s.text name="project.deliverable.removeDeliverable" /]" /> 
              </a>
          </td>
        </tr>  
      [/#list]
    [/#if]
    </tbody>
  </table>
[/#macro]