<#include "share/header.ftl">
<#if !response??>
	<a href="oAuth">去QQ微博授权</a>
<#else>
	<div >
	<img src="${user.head}/100"/><br/>
	<label>${user.name}</label><br/>
	<label>${user.nick}</label><br/>
	<label>${user.birth_year}-${user.birth_month}-${user.birth_day}</label><br/>
	<label>${user.email}</label><br/>
	<label>${user.fansnum}</label><br/>
	<label>${user.idolnum}</label><br/>
	<label>${user.tweetnum}</label><br/>
	<label>${user.introduction}</label><br/>
	</div>
</#if>
<#include "share/footer.ftl">