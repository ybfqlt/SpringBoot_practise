package com.xns.springboot.component;


import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * @Classname MyErrorAttributes
 * @Description TODO
 * @Date 19-7-27 下午3:17
 * @Created by xns
 */
//给容器中加入我们自己定义的ErrorAttributes
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {


    /**
     *  因为我定义了自己的errorAttributes,所以在ErrorAutoConfiguration中的
     *  @Bean
     *  @ConditionalOnMissingBean(value = ErrorAttributes.class, search = SearchStrategy.CURRENT)
     * 	public DefaultErrorAttributes errorAttributes() {
     * 		return new DefaultErrorAttributes(this.serverProperties.getError().isIncludeException());
     *   }
     *   这个组件不能注入,所以无法获取异常信息,所以要自己实现,又因为ServerProperties已经被注入到容器中,构造器可以直接获取
     *
     */
    public MyErrorAttributes(ServerProperties serverProperties) {
        super(serverProperties.getError().isIncludeException());
    }

    //返回值的map就是页面和json能获取的所有字段
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String,Object> map = super.getErrorAttributes(webRequest,includeStackTrace);
        map.get("exception");
        map.put("company","xns");

        //我们异常处理器携带的数据
        Map<String,Object> ext = (Map<String,Object>)webRequest.getAttribute("ext",0);
        map.put("ext",ext);
        return map;
    }
}
