//package pers.vv.study.schedule.elasticjob;
//
//import org.apache.shardingsphere.elasticjob.lite.api.ShardingContext;
//import org.apache.shardingsphere.elasticjob.lite.api.type.simple.SimpleJob;
//
//public class MyElasticJob implements SimpleJob {
//
//    @Override
//    public void execute(ShardingContext context) {
//        switch (context.getShardingItem()) {
//            case 0:
//                // do something by sharding item 0
//                break;
//            case 1:
//                // do something by sharding item 1
//                break;
//            case 2:
//                // do something by sharding item 2
//                break;
//            // case n: ...
//        }
//    }
//
//}