package com.mzc.util;

import org.commonmark.Extension;
import org.commonmark.ext.gfm.tables.TableBlock;
import org.commonmark.ext.gfm.tables.TablesExtension;
import org.commonmark.ext.heading.anchor.HeadingAnchorExtension;
import org.commonmark.node.Link;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.AttributeProvider;
import org.commonmark.renderer.html.AttributeProviderContext;
import org.commonmark.renderer.html.AttributeProviderFactory;
import org.commonmark.renderer.html.HtmlRenderer;

import java.util.*;

/**
 * @author mazhicheng
 * @date 2020/5/31 - 14:34
 */
public class MarkdownUtils {

    /**
     * makedown格式转换为html格式
     * @param marldown
     * @return
     */
    public static String markdownToHtml(String marldown){
        Parser parser = Parser.builder().build();
        Node document = parser.parse(marldown);
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        return renderer.render(document);
    }

    /**
     * makedow转换成html
     * @param makedown
     * @return
     */
    public static String makedownToHtmlExtensions(String makedown){
        //H标题生成id
        Set<Extension> headomgAncborExtensions = Collections.singleton(HeadingAnchorExtension.create());
        //转换table的html
        List<Extension> tabExtension = Arrays.asList(TablesExtension.create());
        Parser parser = Parser.builder()
                .extensions(tabExtension)
                .build();
        Node document = parser.parse(makedown);
        HtmlRenderer renderer=HtmlRenderer.builder()
                .extensions(headomgAncborExtensions)
                .extensions(tabExtension)
                .attributeProviderFactory(new AttributeProviderFactory() {

                    public AttributeProvider create(AttributeProviderContext attributeProviderContext) {
                        return  new CustomAttributeProvider();
                    }
                })
                .build();
        return renderer.render(document);
    }

    /**
     * 处理标签属性
     *
     */
    static class CustomAttributeProvider implements AttributeProvider{

        @Override
        public void setAttributes(Node node, String tagNmae, Map<String, String> attributes) {

            //改变标签的taeget为——black
            if(node instanceof Link){
                attributes.put("target","_blank");

            }
            if(node instanceof TableBlock){
                attributes.put("class","ui celled table");
            }
        }
    }

    public static  void  main(String[] args){
        String table ="|hello |hi |哈哈哈|\n"+"----|----|----|\n";
        String a = "[imCodeing 爱变换成](http://www.baidu.cn)";
        System.out.println(makedownToHtmlExtensions(a));
    }

}
