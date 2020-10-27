package pers.vv.study.bookkeeper;

import org.apache.bookkeeper.client.BKException;
import org.apache.bookkeeper.client.BookKeeper;
import org.apache.bookkeeper.client.LedgerEntry;
import org.apache.bookkeeper.client.LedgerHandle;

import java.io.IOException;
import java.util.Enumeration;

public class MBookKeeper {

    public static void main(String[] args) throws InterruptedException, BKException, IOException {
        BookKeeper bk = new BookKeeper("localhost:2181");
        // A password for the new ledger
        byte[] ledgerPassword = "test".getBytes();
        // Create a new ledger and fetch its identifier
        LedgerHandle lh = bk.createLedger(BookKeeper.DigestType.MAC, ledgerPassword);
        lh.addEntry("test".getBytes());
        lh.close();
        // Open a ledger
        long ledgerId = 1000L;
        lh = bk.openLedger(ledgerId, BookKeeper.DigestType.MAC, ledgerPassword);
        // Read all available entries
        Enumeration<LedgerEntry> entries = lh.readEntries(0, 1);
        while (entries.hasMoreElements()) {
            System.out.println(new String(entries.nextElement().getEntry()));
        }
        // close
        lh.close();
        bk.close();
    }

}
