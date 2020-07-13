package pers.viviel.study.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.TreeCache;
import org.apache.curator.retry.RetryNTimes;

public class Main {

    public static void main(String[] args) throws Exception {
        String ADDRESS = "localhost:2181";
        CuratorFramework client = CuratorFrameworkFactory.newClient(ADDRESS, new RetryNTimes(10, 5000));
        client.start();

        TreeCache tree = new TreeCache(client, "/vv");
        tree.getListenable().addListener((c, event) -> {
            System.out.println(event.getType().name());
        });
        tree.start();

        Thread.sleep(Integer.MAX_VALUE);
    }

}
