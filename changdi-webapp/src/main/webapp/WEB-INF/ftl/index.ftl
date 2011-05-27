<#include "share/header.ftl">

<#list venues as item>
	<div class="venue-content">
		<p>
			<label>id:${item.id?default(0)?c}</label>
			<label>name:${item.name?default('')}</label>
			<label>description:${item.description?default('')}</label>
			<label>createAt:${item.createAt?default('')}</label>
		</p>
	</div>
</#list>

<#include "share/footer.ftl">