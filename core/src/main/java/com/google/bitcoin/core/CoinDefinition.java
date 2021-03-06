package com.google.bitcoin.core;

import java.math.BigInteger;
import java.util.Date;
import java.util.Map;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: Hash Engineering Solutions
 * Date: 5/3/14
 * To change this template use File | Settings | File Templates.
 */
public class CoinDefinition {


    public static final String coinName = "Compcoin";
    public static final String coinTicker = "CPC";
    public static final String coinURIScheme = "bitcoin";
    //public static final String cryptsyMarketId = "155";
    //public static final String cryptsyMarketCurrency = "BTC";
    //public static final String PATTERN_PRIVATE_KEY_START = "[7X]";

    public enum CoinPrecision {
        Coins,
        Millicoins,
    }
    public static final CoinPrecision coinPrecision = CoinPrecision.Coins;

    
    public static final boolean proofOfStake = false;

    public static final String BLOCKEXPLORER_BASE_URL_PROD = "http://explorer.compcoin.io/";    //blockr.io
    public static final String BLOCKEXPLORER_ADDRESS_PATH = "address/";             //blockr.io path
    public static final String BLOCKEXPLORER_TRANSACTION_PATH = "tx/";              //blockr.io path
    public static final String BLOCKEXPLORER_BLOCK_PATH = "block/";                 //blockr.io path
    public static final String BLOCKEXPLORER_BASE_URL_TEST = BLOCKEXPLORER_BASE_URL_PROD;

    //public static final String DONATION_ADDRESS = "FHxPW2J7JQygimYcpP5j43o8rMHx3qjHHo"; 
    //public static final String DONATION_ADDRESS_TESTNET = "";  

    public static boolean checkpointFileSupport = true;

    public static final int TARGET_TIMESPAN = 150; 
    public static final int TESTNET_TARGET_TIMESPAN = 30; 
    //public static final int TARGET_SPACING = (int)(1 * 60);  
    //public static final int INTERVAL = TARGET_TIMESPAN / TARGET_SPACING;  //36 blocks

    /*public static final int getInterval(int height, boolean testNet) {
            return INTERVAL;   
    }
    public static final int getIntervalCheckpoints() {
            return INTERVAL;

    }
    public static final int getTargetTimespan(int height, boolean testNet) {
            return TARGET_TIMESPAN;   
    }*/

    public static int spendableCoinbaseDepth = 70; //main.h: static const int COINBASE_MATURITY
    public static final BigInteger MAX_MONEY = BigInteger.valueOf(10000000L).multiply(Utils.COIN);                 //main.h:  MAX_MONEY

    public static final BigInteger DEFAULT_MIN_TX_FEE = BigInteger.valueOf(1000);   // MIN_TX_FEE
    //public static final BigInteger DUST_LIMIT = BigInteger.valueOf(1000); //main.h CTransaction::GetMinFee        0.01 coins

    public static final int PROTOCOL_VERSION = 70003;          //version.h PROTOCOL_VERSION
    public static final int MIN_PROTOCOL_VERSION = 70003;        //version.h MIN_PROTO_VERSION
    public static final int BIP0031_VERSION = 60000;

    public static final int BLOCK_CURRENTVERSION = 2;   //CBlock::CURRENT_VERSION
    public static final int MAX_BLOCK_SIZE = 1 * 1000 * 1000;


    //public static final boolean supportsBloomFiltering = false; //Requires PROTOCOL_VERSION 70000 in the client

    public static final int Port    = 13674;//protocol.h GetDefaultPort(testnet=false)
    public static final int TestPort= 13677;//protocol.h GetDefaultPort(testnet=true)

    //
    //  Production
    //
    public static final int AddressHeader = 28;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS
    public static final int p2shHeader = 5;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS
    //public static final boolean allowBitcoinPrivateKey = false; //for backward compatibility with previous version of digitalcoin
    public static final int dumpedPrivateKeyHeader = 128;   //common to all coins
    //public static final long oldPacketMagic = 0xfbc0b6db;      //0xfb, 0xc0, 0xb6, 0xdb
    public static final long PacketMagic = 0xf1b3b6d7L;

    //Genesis Block Information from main.cpp: LoadBlockIndex
    static public long genesisBlockDifficultyTarget = (0x1e01f998L);         //main.cpp: LoadBlockIndex
    static public long genesisBlockTime = 1396281265L;                       //main.cpp: LoadBlockIndex
    static public long genesisBlockNonce = (4172846L);                         //main.cpp: LoadBlockIndex
    static public String genesisHash = "0000018b0b21f7829f618e4e679d5ae7f33541189e402c04a91e050970161924"; // NB: PoW hash here
    static public String genesisMerkleRoot = "c900d294567c4363a0d8481f24e635df784e5b480e7b7eb97f0841628fcbe93a";
    static public BigInteger genesisBlockValue = BigInteger.valueOf(35).multiply(Utils.COIN);
    //taken from the raw data of the block explorer
    //static public String genesisTxInBytes = "04ffff001d01044c5957697265642030392f4a616e2f3230313420546865204772616e64204578706572696d656e7420476f6573204c6976653a204f76657273746f636b2e636f6d204973204e6f7720416363657074696e6720426974636f696e73";   //"limecoin se convertira en una de las monedas mas segura del mercado, checa nuestros avances"
    //static public String genesisTxOutBytes = "040184710fa689ad5023690c80f3a49c8f13f8d45b8c857fbcbc8bc4a8e4d3eb4b10f4d4604fa08dce601aaf0f470216fe1b51850b4acf21b179c45070ac7b03a9";

    //net.cpp strDNSSeed
    static public String[] dnsSeeds = new String[] {
    	//"188.226.128.85", "188.226.252.39",
    };

    public static int minBroadcastConnections = 0;   //0 for default; we need more peers.

    //
    // TestNet
    //
    public static final boolean supportsTestNet = true;
    public static final int testnetAddressHeader = 75;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS_TEST
    public static final int testnetp2shHeader = 196;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS_TEST
    public static final long testnetPacketMagic = 0x01130607;      //
    public static final String testnetGenesisHash = "000079a939cdc196fb930f732fdbaef86c19d88486d7874464ef690419af40d0";
    static public long testnetGenesisBlockDifficultyTarget = (0x1f00e3d6L);         //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockTime = 1403787088L;                       //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockNonce = (41360L);                         //main.cpp: LoadBlockIndex

    public static final int maxMoney = 10000000;
    public static final int preminedMoney = 1500000;
    public static final int blockReward = 35;

    public static final int maxMoneyHeight = 
    		(maxMoney - preminedMoney)/ blockReward;
    
    static int getBlockValue(int height)
    {
      int nSubsidy = blockReward;
      
      if(height == 1)
        nSubsidy = preminedMoney;
      else if (height == maxMoneyHeight + 1)
        nSubsidy = 5;
      else if (height > maxMoneyHeight)
        nSubsidy = 0;
      return nSubsidy;
    }

    //main.cpp GetBlockValue(height, fee)
    /*public static final BigInteger GetBlockReward(int height)
    {
        int COIN = 1;
        BigInteger nSubsidy = Utils.toNanoCoins(100, 0);
        if (height == 1)
            nSubsidy = Utils.toNanoCoins(420000, 0);
        return nSubsidy;
    }*/

    //public static int subsidyDecreaseBlockCount = 4730400;     //main.cpp GetBlockValue(height, fee)

    //public static BigInteger proofOfWorkLimit = Utils.decodeCompactBits(0x1e01f998L);  //pars.h min_difficulty_by_design

    static public String[] testnetDnsSeeds = new String[] {
    };
    //from main.h: CAlert::CheckSignature
    //public static final String SATOSHI_KEY = "048240a8748a80a286b270ba126705ced4f2ce5a7847b3610ea3c06513150dade2a8512ed5ea86320824683fc0818f0ac019214973e677acd1244f6d0571fc5103";
    //public static final String TESTNET_SATOSHI_KEY = "04517d8a699cb43d3938d7b24faaff7cda448ca4ea267723ba614784de661949bf632d6304316b244646dea079735b9a6fc4af804efb4752075b9fe2245e14e412";
	public static boolean blockVersion6 = false;

    /** The string returned by getId() for the main, production network where people trade things. */
    public static final String ID_MAINNET = "org.compcoin.production";
    /** The string returned by getId() for the testnet. */
    public static final String ID_TESTNET = "org.compcoin.test";
    /** Unit test network. */
    public static final String ID_UNITTESTNET = "com.google.compcoin.unittest";

    //checkpoints.cpp Checkpoints::mapCheckpoints
    public static void initCheckpoints(Map<Integer, Sha256Hash> checkpoints)
    {
    }

    //Unit Test Information
    public static final String UNITTEST_ADDRESS = "CX4g7MN84gWyPgmsyiY8t5iHduF1vbUuM6";
    //public static final String UNITTEST_ADDRESS_PRIVATE_KEY = "XDtvHyDHk4S3WJvwjxSANCpZiLLkKzoDnjrcRhca2iLQRtGEz1JZ";

}
