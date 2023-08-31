package client;

import org.bank.source.ClientController;
import org.bank.source.model.BankData;
import org.bank.test.data.BankDataStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientControllerTest {
    private ClientController clientController;

    private BankDataStub bankDataStub;

    List<BankData> stubbedData;
    @BeforeEach
    public void setup(){
        clientController = new ClientController();
        bankDataStub = new BankDataStub();
        stubbedData = bankDataStub.getAllBankData();
    }
    @Test
    @Order(value = 1)
    @Disabled
    public void getSingleDataTest(){
        System.out.println("Called first");
       List<BankData> uniqueData = clientController.getBankData();
       assertEquals(1,uniqueData.size());
       long count = bankDataStub.getAllBankData()
                    .stream()
                    .peek(System.out::println)
                    .filter(data -> data.ACCOUNT_NUMBER.equals(uniqueData.get(0).ACCOUNT_NUMBER))
                    .count();
       assertEquals(1,count);

    }
    @Test
    @Order(value = 3)
    @Disabled
    public void getAllDataTest(){
        System.out.println("Called third");
        List<BankData> uniqueData = clientController.getAllBankData();
        assertEquals(3,uniqueData.size());
        assertArrayEquals(stubbedData.toArray(),uniqueData.toArray());
        uniqueData.stream().peek(System.out::println).count();
    }
    @Test
    @Order(value = 2)
    public void deleteDataByAccountNameTest(){
        List<String> whereConditions = Arrays.asList(new String[]{"BRANCH_CODE", "ACCOUNT_NUMBER"});
        BankData bankData = new BankData("123456","12345678",null,null,0d);
        List<BankData> uniqueData = clientController.deleteDataByAccountName(bankData,whereConditions);

    }

    @Test
    @Disabled
    public void insertBankDataTest(){
        BankData bankData = new BankData("999999","577855542","M Kameswari","Wroclaw",500.0d);
        stubbedData.add(bankData);
        List<BankData> uniqueData = clientController.insertBankData(bankData);
        assertEquals(4,uniqueData.size());
        assertArrayEquals(stubbedData.toArray(),uniqueData.toArray());
    }
    @Test
    @Disabled
    public void updataBankDataTest(){
        BankData bankData = new BankData("999999","577855542","Maheedhara Kameswari","Poland",600.0d);
        BankData sourceBankData = new BankData("999999","577855542","M Kameswari","Wroclaw",500.0d);

    }
}
