import java.util.*;
import java.security.MessageDigest;
import com.google.gson.GsonBuilder;

class Block{
    public String hash;
    public String previousHash;
    private String data;
    private long timeStamp;
    private int nonce;
    Block(String data, String previousHash){
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculatedHash();
        }
    
    public String calculatedHash(){
        String calculatedHash =  StringUtil.applySha256(previousHash + Long.toString(timeStamp)+Integer.toString(nonce) + data);
        return calculatedHash;
    }  
    
    public void mineBlock(int difficulty){
        String target = new String(new char[difficulty]).replace('\0','0');
        while(!hash.substring(0,difficulty).equals(target)){
            nonce++;
            hash = calculatedHash();
        }
        System.out.println("Block Mined:"+hash);
    }
}

class StringUtil{
    public static String applySha256(String input){
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();
            for(int i=0;i<hash.length;i++){
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}

public class FirstChain {
    public static ArrayList<Block> blockchain = new ArrayList<Block>();
    public static int difficulty= 5;
    
    public static void main(String[] args){
        blockchain.add(new Block("Hi Im the first block","0"));
        System.out.println("Trying to Mine block 1...");
        blockchain.get(0).mineBlock(difficulty);
        
        blockchain.add(new Block("Hi Im the second block",blockchain.get(blockchain.size()-1).hash));
        System.out.println("Trying to Mine block 2...");
        blockchain.get(1).mineBlock(difficulty);
        
        blockchain.add(new Block("Hi Im the third block",blockchain.get(blockchain.size()-1).hash));
        System.out.println("Trying to Mine block 3...");
        blockchain.get(2).mineBlock(difficulty);
        
        System.out.println("\nBlockchain is valid:"+isChainValid());
       
        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println(blockchainJson);
    }
    
    public static Boolean isChainValid(){
        Block currentBlock;
        Block previousBlock;
        String hashTarget = new String(new char[difficulty]).replace('\0','0');
        
        for(int i=1;i<blockchain.size();i++){
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i-1);
            if(!currentBlock.hash.equals(currentBlock.calculatedHash())){
                System.out.println("Current Hashes not equal");
                return false;
            }
            if(!previousBlock.hash.equals(currentBlock.previousHash)){
                System.out.println("Previous Hashes not equal");
                return false;
            }
            
            if(!currentBlock.hash.substring(0,difficulty).equals(hashTarget)){
                System.out.println("This block hasn't been mined");
                return false;
            }
        }
        return true;
    }
}
    
    
    
    
  
