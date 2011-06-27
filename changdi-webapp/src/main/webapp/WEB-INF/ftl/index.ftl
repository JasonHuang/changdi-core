<#include "share/header.ftl">
<#if !response??>
	<a href="oAuth">去QQ微博授权</a>
<#else>
<div class="top-nav">
	<div class="bd">
		<div class="top-nav-info">
   			<a href="http://www.douban.com/doumail/">豆邮</a>
    		<a target="_blank" href="http://www.douban.com/accounts/">jason的帐号</a>
    		<a href="http://www.douban.com/accounts/logout?ck=O5fR">退出</a>
    	</div>
    	<div class="top-nav-items">
        <ul>
                <li class="on">
                  <a href="http://www.douban.com/">豆瓣社区</a>
                </li>
                <li>
                  <a href="http://book.douban.com/">豆瓣读书</a>
                </li>
                <li>
                  <a href="http://movie.douban.com/">豆瓣电影</a>
                </li>
                <li>
                  <a href="http://music.douban.com/">豆瓣音乐</a>
                </li>
                <li>
                  <a href="http://www.douban.com/location/">豆瓣同城</a>
                </li>
                <li>
                  <a href="http://9.douban.com/" target="_blank">九点</a>
                </li>
                <li>
                  <a href="http://douban.fm/" target="_blank">豆瓣FM</a>
                </li>
        </ul>
    </div>
    </div>
</div>

<div id="wrapper">
	<div id="header">
		<div id="db-nav-main" class="site-nav">
    		<div class="site-nav-logo">
      			<a href="http://www.douban.com">
          		<img src="http://img3.douban.com/pics/nav/lg_main_a7.png" alt="豆瓣">
       		<em>首页</em>
      			</a>
    		</div>

    		<div class="bd">
			    <div class="nav-srh">
			        <form name="ssform" method="get" action="http://www.douban.com/search">
			            <div class="inp">
			                <span><input name="search_text" type="text" title="成员、小组、音乐人、主办方" size="22" maxlength="60" value=""/></span>
			                <span><input class="bn-srh" type="submit" value="搜索"/></span>
			            </div>
			        </form>
			
			    </div>

			    <div class="site-nav-items">
			        <ul>
			             
			                     <li><a href="http://www.douban.com">首页</a></li>
			             
			                     <li><a href="http://www.douban.com/mine/">我的豆瓣</a></li>
			             
			                     <li><a href="http://www.douban.com/group/">我的小组</a></li>
			             
			                     <li><a href="http://www.douban.com/explore/">浏览发现</a></li>
			
			        </ul>
			    </div>
    		</div>
    		<div class="ext"></div>
		</div>
<script>
setTimeout(function(){
    $('#db-nav-main .nav-srh form').prettyField();
    $('#db-nav-main .guide a.close').click(function(e) {
        e.preventDefault();
        $.post_withck('/j/accounts/hidetip',{kind: $(this).next().val()}, function(r){});
        $(this).parent().fadeOut('normal');
    });
}, 0);
</script>

	</div>

	<div id="content">
   		<div class="grid-16-8 clearfix">
       	<div class="article drop-area ui-sortable">
       	
		
				<div class="clear"></div>
				<div style="width:590px;">
		        	<div class="photoin"><a class="nbg" href="http://www.douban.com/photos/album/36041987/" title="星座" alt="星座"><img src="http://img3.douban.com/view/photo/albumicon/public/p684775749.jpg" class="album_s"/></a>
		        	<div class="ll pl" style="padding-top:8px;width:138px"><a href="http://www.douban.com/photos/album/36041987/">星座</a><br/>2011-03-18更新</div></div>
		          <div class="clear"></div>
		    	</div>
			</div>
			 <div class="aside drop-area ui-sortable">
				<div id="profile">
					<div class="infobox">
						<div class="ex1"><span></span></div>
			   				<div class="bd">
								<img src="${user.head}/100"/><br/>
								<label>${user.name}</label><br/>
								<div class="sep-line"></div>
								<label>${user.nick}</label><br/>
								<label>${user.birth_year}-${user.birth_month}-${user.birth_day}</label><br/>
								<label>${user.email}</label><br/>
								<label>${user.fansnum}</label><br/>
								<label>${user.idolnum}</label><br/>
								<label>${user.tweetnum}</label><br/>
								<label>${user.introduction}</label><br/>
							</div>
						</div>
					</div>	
				</div>
			</div>
			<div id="footer">
				<span id="icp" class="fleft gray-link">
				    &copy; 2005－2011 douban.com, all rights reserved
				</span>
				<span class="fright">
				    <a href="http://www.douban.com/about">关于豆瓣</a>
				
				    · <a href="http://www.douban.com/about?topic=teamup">在豆瓣工作</a>
				    · <a href="http://www.douban.com/about?topic=contactus">联系我们</a>
				    · <a href="http://www.douban.com/about?policy=disclaimer">免责声明</a>
				    
				    · <a href="http://www.douban.com/help/">帮助中心</a>
				    · <a href="http://www.douban.com/service/">API</a>
				
				    · <a href="http://www.douban.com/mobile/">手机豆瓣</a>
				    · <a href="http://www.douban.com/partner/">品牌俱乐部</a>
				
				</span>
   			</div>
		</div>
	</div>
</div>
</#if>
<#include "share/footer.ftl">