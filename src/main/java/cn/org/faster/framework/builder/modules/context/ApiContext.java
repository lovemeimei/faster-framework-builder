package cn.org.faster.framework.builder.modules.context;

import cn.org.faster.framework.builder.common.context.BuildContext;
import cn.org.faster.framework.builder.common.model.BuilderModel;
import cn.org.faster.framework.builder.common.strategy.BuildStrategy;
import cn.org.faster.framework.builder.modules.strategy.api.ApiApplicationYmlStrategy;
import cn.org.faster.framework.builder.modules.strategy.api.ApiControllerStrategy;
import cn.org.faster.framework.builder.modules.strategy.api.ApiPomStrategy;
import cn.org.faster.framework.builder.modules.strategy.api.ApiBaseTestStrategy;
import cn.org.faster.framework.builder.modules.strategy.java.*;

import java.util.List;

/**
 * @author zhangbowen
 * @since 2018/12/14
 */
public class ApiContext extends BuildContext {

    public ApiContext(BuilderModel builderModel) {
        super(builderModel);
    }

    @Override
    protected void initBuildStrategy(List<BuildStrategy> strategyList) {
        strategyList.add(new EntityStrategy(builderModel));
        strategyList.add(new MapperStrategy(builderModel));
        strategyList.add(new RequestStrategy(builderModel));
        strategyList.add(new ApiPomStrategy(builderModel));
        strategyList.add(new ServiceStrategy(builderModel));
        strategyList.add(new SpringBootApplicationStrategy(builderModel));
        strategyList.add(new GitIgnoreStrategy(builderModel));
        strategyList.add(new ApplicationEnvYmlStrategy(builderModel));
        strategyList.add(new ApiApplicationYmlStrategy(builderModel));
        strategyList.add(new ApiControllerStrategy(builderModel));
        strategyList.add(new ApiBaseTestStrategy(builderModel));
        strategyList.add(new TestStrategy(builderModel));
    }
}
