package cn.org.faster.framework.builder.modules.strategy.adminWeb;

import cn.org.faster.framework.builder.common.model.BuilderModel;
import cn.org.faster.framework.builder.common.strategy.adapter.WebStrategyAdapter;
import cn.org.faster.framework.builder.common.utils.FreemarkerUtils;
import freemarker.template.Template;

import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author zhangbowen
 * @since 2018/12/17
 */
public class WebPackRcProdStrategy extends WebStrategyAdapter {
    public WebPackRcProdStrategy(BuilderModel builderModel) {
        super(builderModel);
    }

    @Override
    public void process(ZipOutputStream zipOutputStream) throws IOException {
        Template WebpackRcProdTemp = FreemarkerUtils.cfg.getTemplate("/adminWeb/.webpackrc.prod.js.ftl");
        String zipFileName = "/config/.webpackrc.prod.js";
        zipOutputStream.putNextEntry(new ZipEntry(zipFileName));
        zipOutputStream.write(FreemarkerUtils.processIntoStream(WebpackRcProdTemp, builderModel));
        zipOutputStream.closeEntry();
    }
}
