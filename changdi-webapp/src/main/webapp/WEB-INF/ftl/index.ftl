<#include "share/header.ftl">

<#list venues as item>
	<div>
	id:${item.id?default(0)?c}<br/>
	name:${item.name?default('')}<br/>
	description:${item.description?default('')}<br/>
	createAt:${item.createAt?default('')}<br/><br/>
	</div>
</#list>

<#include "share/footer.ftl">