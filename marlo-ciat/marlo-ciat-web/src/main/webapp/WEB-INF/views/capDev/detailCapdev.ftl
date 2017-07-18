[#ftl]

[#assign customCSS = ["${baseUrl}/css/global/customDataTable.css"] /]
[#assign customCSS = ["${baseUrl}/css/capDev/capacityDevelopment.css"] /]
[#assign customJS = ["${baseUrl}/js/capDev/capacityDevelopment.js"] /]



[#include "/WEB-INF/global/pages/header.ftl" /]
[#include "/WEB-INF/global/pages/main-menu.ftl" /]







<script src="${baseUrl}/bower_components/jquery/dist/jquery.min.js"></script>
<script src="${baseUrl}/js/capDev/capacityDevelopment.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/xlsx/0.7.7/xlsx.core.min.js"></script>


<div class="container"> 

	<div class="row">
		<div class="col-md-12 capdevinfo">
			help text
		</div>
	</div> 

	<div class="col-md-3 capDevMenu">
		[#include "/WEB-INF/views/capDev/menu-capdev.ftl" /]
	</div>
	
	
	<div class="col-md-9 ">
	
		<div class="col-md-12">
			<div class="pull-right">
				<a class="" href="[@s.url action='${centerSession}/capdev' /] "><span class="glyphicon glyphicon-circle-arrow-left"></span>[@s.text name="capdev.gotoBack" /]</a> 
			</div>
		</div>
		
		<div class="col-md-12 form-group newCapdevForm"> 

			[@s.form action=actionName method="POST" enctype="multipart/form-data" cssClass=""]
			<!-- Radio Buttons-->
			<div class="row newCapdevField" > 
				
				<div class="col-md-12">
					<div class="col-md-3">
						<div class="radio">
						  <label><input  id="individual" type="radio" hidden="true" name="capdev.category" class="radioButton" value="${capdev.category}"  /></label>
						</div>
					</div>
					<div class="col-md-3">
						<div class="radio">
						  <label><input id="gruops" type="radio" hidden="true" name="capdev.category" class="radioButton"  value="${capdev.category}" /> </label>
						</div>
					</div>
					
				</div>
			</div>

			<div  class="fullForm" >
				<!-- Title-->
				<div class="row newCapdevField group individual" style="display:${(capdev.category == 1)?string('none','block')}">
					<div class="col-md-12 "> 
						<div class="" > 
							[@customForm.input name="capdev.title" type="text" help="capdev.help.title" i18nkey="capdev.form.title"  required=true  /]
						</div>
					</div>
				</div>

				<!-- type and contact Person -->
				<div class="row">
					<div class="col-md-12 newCapdevField"> 
						<!-- type-->
						<div class="col-md-6 "> 
							[@customForm.select name="capdev.capdevType.id" listName="capdevTypes" keyFieldName="id" displayFieldName="name" help="capdev.help.type" i18nkey="capdev.form.type"  placeholder="capdev.select" required=true editable=true/]
						</div>

						<!-- Contact person -->
						<div class="col-md-6 contactField group individual">
							[@customForm.input name="contact" i18nkey="capdev.form.contactPerson" type="text" help="capdev.help.contact" className='contact'  required=true  /]
							<input class="ctFirsName" type="hidden" name="capdev.ctFirstName" value="${(capdev.ctFirstName)!}" /> 
							<input class="ctLastName" type="hidden" name="capdev.ctLastName" value="${(capdev.ctLastName)!}" /> 
							<input class="ctEmail" type="hidden" name="capdev.ctEmail" value="${(capdev.ctEmail)!}" /> 
						</div>
					</div>
				</div>

				<!-- dates -->
				<div class="row ">
					<div class="col-md-12 newCapdevField">
						<!-- Strart date-->
						<div class="col-md-6 ">
							[@customForm.input name="capdev.startDate" i18nkey="capdev.form.startDate" type="text"  help="capdev.help.startDate" required=true  editable=true className="capdevstartDate"/]
						</div>
						<!-- end date-->
						<div class="col-md-6 ">
							[@customForm.input name="capdev.endDate" i18nkey="capdev.form.endDate" type="text" help="capdev.help.endDate" editable=true /]
						</div>
					</div>
				</div>

				<!-- num participants, num men and num women -->
				<div class="row">
					<div class="col-md-12 newCapdevField">
						<div class="col-md-6 group individual">
							[@customForm.input name="capdev.numParticipants" i18nkey="capdev.form.numParticipants" type="text" help="capdev.help.numParticipants"  editable=true  /]
						</div>
						<div class="col-md-3 group individual">
							[@customForm.input name="capdev.numMen" i18nkey="capdev.form.numMen" help="capdev.help.numMen" type="text"  /]
						</div>
						<div class="col-md-3 group individual">
							[@customForm.input name="capdev.numWomen" i18nkey="capdev.form.numWomen" help="capdev.help.numWomen" type="text"  /]
						</div>
					</div>
				</div>


				<!-- groups participants-->
				<div class="row grupsParticipantsForm">
					<div class="col-md-12 newCapdevField participantsheader">
						<div class="col-md-6  participantsTitle">
							[@s.label key="capdev.form.participants" /]
						</div>
						<div class="col-md-6 ">
							<div class="pull-right">
								<button type="button" class="capdevButtons" aria-label="Left Align" >
									<a class="downloadButton" href="[@s.url action='${centerSession}/downloadFile' /] ">[@s.text name="capdev.downloadTemplate" /]</a> 
								</button>
							</div>
						</div>
					</div>

					<div class="row newCapdevField">
						<div class="col-md-12 newCapdevField participantsBox">
							<div class="col-md-12">
								[@s.file id="uploadFile" name="uploadFile" label="Select a File to upload" size="40" class="uploadParticipants"/]
							</div>
							

							<div class="col-md-12" style="margin-top: 10px;">
							<div class="btnPreview">
								<button type="button"  id="btnDisplay" class="capdevButtons" aria-label="Left Align" data-toggle="modal" data-target="#myModa">
									preview
								</button>
							</div>
							

							<div id="filewarning" class="warning" style="display: none; margin-top: 10px;">
							</div>
							<div class="loader" style="display:none;"><img src="${baseUrl}/images/global/loading_2.gif" width="80" height="30"></div>

							<div class="modal fade bd-example-modal-lg" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
							  <div class="modal-dialog modal-lg" role="document">
							    <div class="modal-content highlight">
							      <div class="modal-header">
							      	<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							          <span aria-hidden="true">&times;</span>
							        </button>
							        <h5 class="modal-title" id="exampleModalLabel">Preview participants file</h5>
							        
							      </div>
							      <div id="participantsTable"  class="modal-body">
							        
							      </div>
							     
							    </div>
							  </div>
							</div>
						</div>
						</div>
						
					</div>

					<div class="note participantMessage">
						<p>If you don’t have a participants list please enter the number of participants, number of men and number of women</p>
					</div>
				</div>

				<!-- induvidual participant-->
				<div class="row newCapdevField individualparticipantForm" style="display:none;">
					<div class="col-md-12 ">
						<div class=" participantsTitle newCapdevField" >
							[@s.text name="capdev.participant"][/@s.text]
						</div>
					</div>
					<div class="col-md-12 newCapdevField">
						[@customForm.input name="participant.code" i18nkey="capdev.participant.code" type="text" required=true /]
					</div>
					<div class="col-md-12 newCapdevField">
						<div class="col-md-6">
							[@customForm.input name="participant.name" i18nkey="capdev.participant.firstName" type="text" required=true /]
						</div>
						<div class="col-md-6">
							[@customForm.input name="participant.lastName" i18nkey="capdev.participant.lastName" type="text" required=true /]
						</div>
					</div>
					<div class="col-md-12 newCapdevField">
						<div class="col-md-6 genderSelect">
							<input type="hidden" name="" value="${(participant.gender)!}" class="genderInput"/>
							[@customForm.select name="participant.gender" listName="genders" keyFieldName="value" displayFieldName="displayName" help="" i18nkey="capdev.participant.gender"  placeholder="capdev.select" required=true editable=true className=""/]
						</div>
						<div class="col-md-6 pCitizenshipcountriesList">
							<!-- [@customForm.input name="participant.citizenship" i18nkey="capdev.participant.citizenship" type="text" required=true /] -->
							<input type="hidden" name="" value="${(participant.citizenship)!}" class="citizenshipInput"/>
							[@customForm.select name="participant.citizenship" listName="countriesList" keyFieldName="value" displayFieldName="displayName" help="" i18nkey="capdev.participant.citizenship" className="" multiple=false placeholder="capdev.select" required=true /]
						</div>
					</div>
					<div class="col-md-12 newCapdevField">
						<div class="col-md-6">
							[@customForm.input name="participant.highestDegree" i18nkey="capdev.participant.Highestdegree" type="text" /]
						</div>
						<div class="col-md-6">
							[@customForm.input name="participant.email" i18nkey="capdev.participant.Email" type="text" required=true /]
						</div>
					</div>
					<div class="col-md-12 newCapdevField">
						<div class="col-md-6">
							[@customForm.input name="participant.institution" i18nkey="capdev.participant.Institution" type="text" required=true /]
						</div>
						<div class="col-md-6 pcountryOfInstitucionList">
							<!-- [@customForm.input name="participant.countryOfInstitucion" i18nkey="capdev.participant.country" type="text" required=true /] -->
							<input type="hidden" name="" value="${(participant.countryOfInstitucion)!}" class="countryOfInstitucionInput"/>
							[@customForm.select name="participant.countryOfInstitucion" listName="countriesList" keyFieldName="value" displayFieldName="displayName" help="" i18nkey="capdev.participant.country" className="" multiple=false placeholder="capdev.select" required=true /]
						</div>
					</div>
					<div class="col-md-12 newCapdevField">
						<div class="col-md-6">
							[@customForm.input name="participant.supervisor" i18nkey="capdev.participant.Supervisor" type="text" required=true /]
						</div>
						<div class="col-md-6">
							[@customForm.input name="participant.fellowship" i18nkey="capdev.participant.Fellowship" type="text" /]
						</div>
					</div>
				</div>

				

				<!-- Regions and countries lists -->
				<div class="row">
					<div class="col-md-12">
						<!-- regions-->
						<div class="col-md-5 listContainer panel ">
							<div class="newCapdevField ">
								[@customForm.select name="capdevRegions" listName="regionsList" keyFieldName="id" displayFieldName="name" help="capdev.help.region" i18nkey="capdev.form.region" className="capdevRegionsSelect" multiple=false placeholder="capdev.select"  /]
							</div>

							<div id="capdevRegionsList" class="newCapdevField regionsList">
								<div class="row">
									<div class="col-md-12 panel-body">
										
										<ul class="list">
											[#if capdev.capDevRegions?has_content]
											[#list capdev.capDevRegions as region]
												<li id="" class="capdevRegion  clearfix col-md-3">
													<div class="removeRegion removeIcon" title="Remove region"></div>
													<input class="id" type="hidden" name="capdev.capDevRegions[${region_index}].id" value="${(region.id)!-1}" />
													<input class="cId" type="hidden" name="capdev.capDevRegions[${region_index}].locElement.id" value="${(region.locElement.id)!}" />
													${region.locElement.name}
													<div class="clearfix"></div>
												</li>
												[/#list] 
												[#else]
												<p class="emptyText"> [@s.text name="capdev.notRegions" /]</p> 
											[/#if]
										</ul>
									</div>
								</div>

							</div>
						</div>

						<!-- countries-->
						<div class="col-md-5 listContainer panel">

							<div class="newCapdevField">
								[@customForm.select name="capdevCountries" listName="countryList" keyFieldName="id" displayFieldName="name" help="capdev.help.country" i18nkey="capdev.form.country" className="capdevCountriesSelect" multiple=false placeholder="capdev.select"  /]
							</div>
							<div id="capdevCountriesList" class="newCapdevField countriesList">
								<div class="row">
									<div class="col-md-12 panel-body">
										<ul class="list">
											[#if capdev.capDevCountries?has_content]
											[#list capdev.capDevCountries as country]
											<li id="" class="capdevCountry clearfix col-md-3">
												<div class="removeCountry removeIcon" title="Remove country"></div>
												<input class="id" type="hidden" name="capdev.capDevCountries[${country_index}].id" value="${(country.id)!-1}" />
												<input class="cId" type="hidden" name="capdev.capDevCountries[${country_index}].locElement.id" value="${(country.locElement.id)!}" />
												${country.locElement.name}
												<div class="clearfix"></div>
											</li>
											[/#list]
											[#else]
											<p class="emptyText"> [@s.text name="capdev.notCountries" /]</p> 
											[/#if]
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div> 	
				</div>

				


				<div style="display: none;">
					[@customForm.input name="capdevID" i18nkey="capdev.id" value="${capdev.id}"  type="text"  /]
					[@customForm.input name="capdevCategory" i18nkey="capdev.category" value="${capdev.category}"  type="text"  /]
				</div>




				<!-- buttons -->
				<div class="col-md-12">
						<div class="buttons">	
				        	<div class="buttons-content">        
					          	[@s.submit type="button" name="save" cssClass="button-save"]<span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span> [@s.text name="form.buttons.save" /] [/@s.submit]
					        	<div class="clearfix"></div>
				        	</div>
	    				</div>
				</div>

			</div>

			[/@s.form]
		</div>
	

	</div>
	

</div>




<!-- country list template-->
<ul style="display:none">
  <li id="capdevCountryTemplate" class="capdevCountry clearfix col-md-4">
      <div class="removeCountry removeIcon" title="Remove country"></div>
      <input class="id" type="hidden" name="" value="" />
      <input class="cId" type="hidden" name="capdevCountries[-1]" value="" />
      <span class="name"></span>
      <div class="clearfix"></div>
    </li>
</ul>

<!-- region list template-->
<ul style="display:none">
  <li id="capdevRegionTemplate" class="capdevRegion clearfix col-md-4">
      <div class="removeRegion removeIcon" title="Remove region"></div>
      <input class="id" type="hidden" name="" value="" />
      <input class="rId" type="hidden" name="capdevRegions[-1]" value="" />
      <span class="name"></span>
      <div class="clearfix"></div>
    </li>
</ul>




[#include "/WEB-INF/views/capDev/searchContactPerson.ftl" /]



[#include "/WEB-INF/global/pages/footer.ftl"]



[#macro objectiveMacro element index=0 isTemplate=false]
	
	<div id="objective-${isTemplate?string('template',(element.id)!)}" class="objective  borderBox row"  style="display:${isTemplate?string('none','block')}">
		<div class="removeObjective removeIcon" title="Remove objective"></div>
		<div class="col-md-12">
			 [@customForm.input name="objectiveBody" i18nkey="Objective # ${index + 1}" type="text" /]
		</div>

	</div>
	
[/#macro]


<!-- [#macro disciplineMacro element isTemplate=false]
	<div id="approach-${isTemplate?string('template',(element)!)}" class="approach  borderBox col-md-4 " style="display:${isTemplate?string('none','block')}" >
		<div class="removeDiscipline removeIcon" title="Remove approach"></div>
		<div class="col-md-4">
			 [@s.text name="element" /]
		</div>
	</div>
[/#macro] -->


[#macro outComeMacro element isTemplate=false]
	<div id="outcome-${isTemplate?string('template',(element)!)}" class="outcome  borderBox col-md-4 " style="display:${isTemplate?string('none','block')}" >
		<div class="removeOutCome removeIcon" title="Remove outcome"></div>
		<div class="col-md-4">
			 [@s.text name="element" /]
		</div>
	</div>
[/#macro]





<!-- [#macro countryMacro element name index isTemplate=false]
	[#local customName = "${name}[${index}]"]
	<div id="country-${isTemplate?string('template',(index)!)}" class="country  borderBox col-md-4 " style="display:${isTemplate?string('none','block')}" >
		<div class="removeCountry removeIcon" title="Remove country"></div>
		<div class="col-md-4">
			${name}
			 
		</div>
			}
	</div>
[/#macro]


[#macro regionMacro element isTemplate=false]
	<div id="region-${isTemplate?string('template',(element)!)}" class="region borderBox col-md-4 " style="display:${isTemplate?string('none','block')}" >
		<div class="removeRegion removeIcon" title="Remove region"></div>
		<div class="col-md-4">
			 [@s.text name="element" /]
		</div>
	</div>
[/#macro] -->


