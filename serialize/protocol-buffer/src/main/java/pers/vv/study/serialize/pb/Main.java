package pers.vv.study.serialize.pb;

import com.google.protobuf.Descriptors;
import org.apache.tubemq.corebase.protobuf.generated.ClientBroker;

public class Main {

    public static void main(String[] args) {
        Descriptors.FileDescriptor descriptor = ClientBroker.getDescriptor();
    }

}
