/*
 * Copyright 2013 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.bitcoin.params;

import com.google.bitcoin.core.NetworkParameters;
import com.google.bitcoin.core.Utils;
import com.google.bitcoin.core.CoinDefinition;

import static com.google.common.base.Preconditions.checkState;

/**
 * Parameters for the old version 2 testnet. This is not useful to you - it exists only because some unit tests are
 * based on it.
 */
public class TestNet2Params extends NetworkParameters {
    public TestNet2Params() {
        super();
        //interval = INTERVAL;
        //targetTimespan = TARGET_TIMESPAN;
        proofOfWorkLimit = CoinDefinition.proofOfWorkLimit;
        dumpedPrivateKeyHeader = CoinDefinition.dumpedPrivateKeyHeader;
        addressHeader = 0;
        p2shHeader = CoinDefinition.p2shHeader;
        acceptableAddressCodes = new int[] { addressHeader, p2shHeader };
        port = CoinDefinition.Port;
        packetMagic = CoinDefinition.PacketMagic;
        genesisBlock.setDifficultyTarget
        	(CoinDefinition.genesisBlockDifficultyTarget);
        genesisBlock.setTime
        	(CoinDefinition.genesisBlockTime);
        genesisBlock.setNonce
        	(CoinDefinition.genesisBlockNonce);
        id = ID_MAINNET;
        //subsidyDecreaseBlockCount = 210000;
        //spendableCoinbaseDepth = 100;
        String genesisHash = genesisBlock.getHashAsString();
        checkState(genesisHash.equals(CoinDefinition.genesisHash),
                genesisHash);

        dnsSeeds = CoinDefinition.dnsSeeds;
    }

    private static TestNet2Params instance;
    public static synchronized TestNet2Params get() {
        if (instance == null) {
            instance = new TestNet2Params();
        }
        return instance;
    }

    public String getPaymentProtocolId() {
        return null;
    }
}
