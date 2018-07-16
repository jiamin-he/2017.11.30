/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Sep 27, 2017
 Problem:    Minimum Index Sum of Two Lists
 Difficulty: Easy
 Notes:

Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.

You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.


eg

Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
Output: ["Shogun"]
Explanation: The only restaurant they both like is "Shogun".

Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["KFC", "Shogun", "Burger King"]
Output: ["Shogun"]
Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).

Note:
The length of both lists will be in the range of [1, 1000].
The length of strings in both lists will be in the range of [1, 30].
The index is starting from 0 to the list length minus 1.
No duplicates in both lists.


*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.List;
import java.util.LinkedList;

class Solution1 {

    public String[] findRestaurant(String[] list1, String[] list2){
        //HashMap<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map1 = new HashMap<>();

        int indexSum=Integer.MAX_VALUE;
        //HashSet<String> result = new HashSet<>();
        List<String> result = new LinkedList<>();
        for (int i=0; i<list1.length ; i++) {
            //题目说了没有duplicate
            //if (!map1.containsKey(list1[i])) {
                map1.put(list1[i],i);
                //System.out.println(list1[i] + " " + i);
            //}
        }

        for (int j=0; j<list2.length ; j++ ) {
            Integer i = map1.get(list2[j]);
            if (i != null && i+j <= indexSum) {
                if (i+j < indexSum) {
                    result.clear();
                    indexSum = i+j;
                }
                result.add(list2[j]);
            }
            //map1.remove(list2[j]);

            // if (map1.containsKey(list2[j])) {
                
            //     //indexSum= Math.min(indexSum, j+map1.get(list2[j]));
                
            //     if (j+map1.get(list2[j]) <= indexSum) {
            //         if (j+map1.get(list2[j]) < indexSum) {
            //             result.clear();
            //             indexSum = j+map1.get(list2[j]);
            //         }
                    
            //         result.add(list2[j]);
            //     } 
                
                
            //     map1.remove(list2[j]);
            //     //System.out.println(list2[j] + indexSum + " " + result);
            // }
        }

        
        // String[] x = new String[result.size()];
        // int i=0;
        // for (String s:result ) {
        //     x[i++] = s;
        // }

        // return x;

        return result.toArray(new String[result.size()]);

    }


    public static void main(String[] args) {
        
        long start = System.currentTimeMillis(); // 记录起始时间

        //String[] man = new String[100];
        //String[] woman = new String[100];
        Solution1 s1 = new Solution1();
        String[] man = {"pkwenkodtlbbdgvopqaeygphtlrmo","agfqdph","vagpvsdzqhwnlogzyje","lfsxwnhweveaaekybglvcluyeb","gpgbqii","fboaiwtlfccdolpqutf","swgsvdptrtepv","nqmgha","rfbmlfacpec","mjgmpewjnlwijzx","fxtsgerpchszrkfjpwwigy","yvizbmradwgxedumcbcktxublw","p","ijrbjrqopmbveayra","ckhb","fhjbrzhroorglgbltarrvtjnkz","bsmqkkfmzszgtffpkpjouoxdmofivm","vbqhjdqajtvy","eelflqtsplanaahmxssqe","gwurhajbnavidhipzhxvlf","lfgztikdpethoionvs","ywqhjouxx","zegpdvbmdgslagpvsjnmchspix","rooillldcagevixecdxffz","huhwnjqriyiweilhjzijuftlzp","lha","ashrazctgqgwrm","geg","nkmofftbapqitraxtfnilsfvwvpas","cblx","xhc","ykiatwmdigjxmxevdbd","alzzxhra","zcxbycuiqlvfpuslvv","ufolcgdeo","wnnhai","eypstxtyxnnqnkmqptekdgpdqcdqn","zosncavdfjcsdnrxdp","ptopwfkziuttfeazrrglqdbszvr","qlewoezxzmlhgypikhdl","ykoyilcm","fmgqdzvdtyethyynjjpbl","dxeyeyejkosdpnub","ymlznwinj","qyfopqgmglfiofw","wwqbevusanvcdzeshcglrzlarer","tmsfjgfjdjdbczcseznowpptr","zkrcckbowwjxmfmdikfsbpyxrmgg","aooilovrtwqoaremskb","acqnnodwqzwlqnynvb","xinbdvhzfykpmzpecgngelczoukzd","ugjnsgqlp","vdztloyrjpzzylesddiewfemmbgfwe","ucnfeysd","cywlrzkl","rezogqmazduvkcypiupyitmhrfmzki","hydpvnbhqpkvrcc","axdaqveyksrmpc","l","zuzgiuonhoaaqmafflrnsamdkefoki","wbtrhqdbwqyrvjizkgj","hyxexwoosybkpifyohasxtk","kexssggfp","eblxqnyke","etwelbjtxilczjudlyziyosp","coxufsaunxexcshrcqyjz","hlcyxndydrxgebcjtgrjlfhhiqeh","vlhyfvzcuuqrqymnzlbqwlwyk","xo","n","hytiwcsrbwyj","kbsglfxut","mducxmhhvuuoaxazhwpsuisush","fqoxrbegbqfseoiqvevfjua","cugcsdfdgggnxbsrloqynmjisfxqcf","gwmoxooqbgkuqhitqndhjknpoi","tvwhfeoxshl","ltvkvjigjqdjmfqihssvnnmxke","tvhkudu","utwqphdxvmtvtjw","npjohbkidogcjbkpairnmmgslk","xtzyn","shufzxmpntnwkljqlayypynmnsvjnq","iwmovzzkfpvixarqckonwqhb","bdjntlktemditgnn","tphnrrekc","jbtpcxbxdbdpjztbvp","jxejmmiwfrrknjyek","jzfkmowocsuhipwvyavcimgslsa","pgsbqvig","fnxfo","ys","jovaimqzyyputxnatlgvtflxmjwrgy","fndfnvpnmgcxjbfydgwiwpvst","eikqjjhbfnabekalchmoigbsvj","esvmtdtyojpoccpnhmweleclk","idrkmks","ucxqf","qaaoyjczafkqyncmmuqfj","xfhfqdqnklxq","krtfunvglmtcwasqlvhq","uilnponlhvulz","hpzca","fhukhpkax","bv","xxfrzciifwxwzkqlhzi","upmawfjrcvyqphcgznqvlunehgm","stbyc","klgybdvijbdraoveascq","zhcnue","njnpajotnwihwedlefrukx","mtndwtean","oblhinaeguymmkleqeogwrzmbltl","htjlnvbdfuzsjypkanhzg","zhjn","pjgfwoikxbybblja","ljdkfxvylzmspudjqqugddxrnhn","isl","azusu","ymyzwmsxcirfwhsafs","uvpjsrqhwxdoeuc","bl","gfubyw","sfxkoexlvpihhfhfq","jsmzeshdnugttvppha","vdvhdvfztaxcyhjdugctrvkgulmbj","knwvl","xengrpxq","qggmtusbpnypjbxcisnoy","rhehzhnlk","ztanalcvncvm","favfgqwpedkohfkoakisbmbxbxf","mofdl","fyfiwcckdrjjpqfyrldhdyvu","fuosbwciqqzosy","chnbkhdgyjoxeglvfc","xflneeeaomxjphvgyohoakxhj","stpuhrfbhoxf","czoepwnymcz","rvscpckcpjwgulnfnelspis","frtrodsnrmsmaaws","sykhquipjd","rrwyr","oglbicrgqvradxwtghghppnzznq","lhaijmcqlnrgimhbptwmkwt","lwdhpatigvhypgzrertalatqspohi","leyshdfdlagoalvfbegapxregtuh","occgkf","gscljupcrmbbeobwvdht","kiul","syc","uoejbnenp","takqafyujrchibalhi","gjcgpxz","jiuiut","faegljhiknwlygwhlu","yxsybpiprmuhzplfphfeqazzyndtv","ktbjtqyvuuxqajcesnaw","huuftubpzskytmniladxkkgczftxp","hjiq","d","udqooeglslqpajnip","lztmnoajehsvz","ybvtkizlmyfngyjwwowgsm","xgvvsydndmgs","smbvogzsmbaxktmqwleprmbdxqf","izdo","sdvhj","qyn","framwuszazkwdilvtylmkru","jmbefcplwqosvfx","kgsptbnifrvczouohrrprli","gcydrneexbcuqopkpcmd","tewapttno","lmhuzhpzmym","yqzblljae","pgxnwszovqgqtcqpzmssneqejgjs","xwetnsmpotlpn","utraamepcsomyxsqbkshgyraleekxw","dvjhqppvoowntco","yohsoxdaubemaogltuk","nasrnrizinuypjdnjehqqoitmvk","xerymxgwvzcb","ouzklsdedbvwwketdhcfeuluvckf","ztindosdnqsyquuhzjzpxkbeefun","kfjirgxu","ypmskmp","wsi","pcfbmtafjvrurtrvjsumfjfttu","aqlwxsrxggtfnz","vbvbde","ceyogdjazwskvjbdwrvufpqcjrxpws","vfhpldeneeqxykmum","vuqxhsrspvqath","tloeehsq","zo","hsxjfwgbuorfznekqdvahrxgui","ctsetmijpnp","jjdizlchlorva","rvrfcepmxpeofenooth","qojwwpjt","gtdq","rbdbetwubqjppupythw","ccdllhhubyjxfmvmxdcmpzdwy","vs","ndfm","selamkurrltpjkt","whxez","woryubernrrwthyce","ozzcx","abtsca","nqyxdju","phuolroyieomapmirpvaldtksgl","yaqhaymtozosbacorzavpgdgl","dbzlkbdgrtavnorpfvuvnxwnzeoc","user","dbtfwbavxuxqzjtycorez","hhemkmkwuikfasranjgsjtug","obsskhdangnyiok","ikkzxhjapdmkyiutryhzvsijxzeo","hvbgprgostxbh","ecnzsirsqqqwldmzsat","pewwoxivlouurvfsadrc","lbujpsqpfk","eqjukrlgnbpuesgea","sgsnxtsznntdptmxjg","bpkwyfwccmnjqwdyhxrjaaxjcw","omvzwyrzlwstnwhwhssajzhbsd","ux","exlyaiolmjrca","zpdbagmcdfltcoiobkdrticgzeyn","bqbebomqulgwltbortyu","ihgevtuipgkvqgpkhlui","tvrippfy","pdbmjihtodwwa","siucrhynh","izvwi","bxhsxqhtbdsgpfeiqpdjumcjm","zrnnxdcd","mfpobuitnnxmkddwwzlfauosuzd","utolwmietafptpdnb","mkointotmaled","likkuxoyubyandcnm","mszirwc","qp","dhvshmxnljtsozhsjugbokxjiiapmb","jxibbfteyfqh","strbmsndazagstxvojxc","tpyrljqdhatboqrnnnq","whjktettjhafcviiivw","pqcetglnhibyhmveyblnlrymw","fdrcqutgrpfdaec","cyfypt","iezxlfmnhwlvpgzensnq","iznzwltutyxd","dlwbfch","qyxaibavemizoahxwhtjexaujzbm","nrqifrrhcxkuny","yymgcbawh","wd","ztuolqf","slrdlcqyevsjvobfd","glotjh","dsbds","tpetl","fryosmcawjsvbutg","hudmoskbkakhsjqyuhrrt","aww","xjluxthorodhosxkrn","fkyhahxbisvfjxj","vkslygnbphhvdpauxjnfn","vvxoqmsatgqanusjbyrxwdshvven","hyb","qxxowalutfwwpv","sntazpdaodhdaid","ws","tsg","crpwxtfukvethkwhtisxqmvohsx","qfcpjzokpxxhgqajgq","svzaumwyydtuveq","inmwdmzejyl","aexhlovhykxeoyxfi","zswuf","hiuxr","fcxnirvfxzevmveemo","cffdctpjzpgvuinotvnywxqph","yzjbscqhtfyuubljpkjmxt"};
        String[] woman = {"yzjbscqhtfyuubljpkjmxt","cffdctpjzpgvuinotvnywxqph","fcxnirvfxzevmveemo","hiuxr","zswuf","aexhlovhykxeoyxfi","inmwdmzejyl","svzaumwyydtuveq","qfcpjzokpxxhgqajgq","crpwxtfukvethkwhtisxqmvohsx","tsg","ws","sntazpdaodhdaid","qxxowalutfwwpv","hyb","vvxoqmsatgqanusjbyrxwdshvven","vkslygnbphhvdpauxjnfn","fkyhahxbisvfjxj","xjluxthorodhosxkrn","aww","hudmoskbkakhsjqyuhrrt","fryosmcawjsvbutg","tpetl","dsbds","glotjh","slrdlcqyevsjvobfd","ztuolqf","wd","yymgcbawh","nrqifrrhcxkuny","qyxaibavemizoahxwhtjexaujzbm","dlwbfch","iznzwltutyxd","iezxlfmnhwlvpgzensnq","cyfypt","fdrcqutgrpfdaec","pqcetglnhibyhmveyblnlrymw","whjktettjhafcviiivw","tpyrljqdhatboqrnnnq","strbmsndazagstxvojxc","jxibbfteyfqh","dhvshmxnljtsozhsjugbokxjiiapmb","qp","mszirwc","likkuxoyubyandcnm","mkointotmaled","utolwmietafptpdnb","mfpobuitnnxmkddwwzlfauosuzd","zrnnxdcd","bxhsxqhtbdsgpfeiqpdjumcjm","izvwi","siucrhynh","pdbmjihtodwwa","tvrippfy","ihgevtuipgkvqgpkhlui","bqbebomqulgwltbortyu","zpdbagmcdfltcoiobkdrticgzeyn","exlyaiolmjrca","ux","omvzwyrzlwstnwhwhssajzhbsd","bpkwyfwccmnjqwdyhxrjaaxjcw","sgsnxtsznntdptmxjg","eqjukrlgnbpuesgea","lbujpsqpfk","pewwoxivlouurvfsadrc","ecnzsirsqqqwldmzsat","hvbgprgostxbh","ikkzxhjapdmkyiutryhzvsijxzeo","obsskhdangnyiok","hhemkmkwuikfasranjgsjtug","dbtfwbavxuxqzjtycorez","user","dbzlkbdgrtavnorpfvuvnxwnzeoc","yaqhaymtozosbacorzavpgdgl","phuolroyieomapmirpvaldtksgl","nqyxdju","abtsca","ozzcx","woryubernrrwthyce","whxez","selamkurrltpjkt","ndfm","vs","ccdllhhubyjxfmvmxdcmpzdwy","rbdbetwubqjppupythw","gtdq","qojwwpjt","rvrfcepmxpeofenooth","jjdizlchlorva","ctsetmijpnp","hsxjfwgbuorfznekqdvahrxgui","zo","tloeehsq","vuqxhsrspvqath","vfhpldeneeqxykmum","ceyogdjazwskvjbdwrvufpqcjrxpws","vbvbde","aqlwxsrxggtfnz","pcfbmtafjvrurtrvjsumfjfttu","wsi","ypmskmp","kfjirgxu","ztindosdnqsyquuhzjzpxkbeefun","ouzklsdedbvwwketdhcfeuluvckf","xerymxgwvzcb","nasrnrizinuypjdnjehqqoitmvk","yohsoxdaubemaogltuk","dvjhqppvoowntco","utraamepcsomyxsqbkshgyraleekxw","xwetnsmpotlpn","pgxnwszovqgqtcqpzmssneqejgjs","yqzblljae","lmhuzhpzmym","tewapttno","gcydrneexbcuqopkpcmd","kgsptbnifrvczouohrrprli","jmbefcplwqosvfx","framwuszazkwdilvtylmkru","qyn","sdvhj","izdo","smbvogzsmbaxktmqwleprmbdxqf","xgvvsydndmgs","ybvtkizlmyfngyjwwowgsm","lztmnoajehsvz","udqooeglslqpajnip","d","hjiq","huuftubpzskytmniladxkkgczftxp","ktbjtqyvuuxqajcesnaw","yxsybpiprmuhzplfphfeqazzyndtv","faegljhiknwlygwhlu","jiuiut","gjcgpxz","takqafyujrchibalhi","uoejbnenp","syc","kiul","gscljupcrmbbeobwvdht","occgkf","leyshdfdlagoalvfbegapxregtuh","lwdhpatigvhypgzrertalatqspohi","lhaijmcqlnrgimhbptwmkwt","oglbicrgqvradxwtghghppnzznq","rrwyr","sykhquipjd","frtrodsnrmsmaaws","rvscpckcpjwgulnfnelspis","czoepwnymcz","stpuhrfbhoxf","xflneeeaomxjphvgyohoakxhj","chnbkhdgyjoxeglvfc","fuosbwciqqzosy","fyfiwcckdrjjpqfyrldhdyvu","mofdl","favfgqwpedkohfkoakisbmbxbxf","ztanalcvncvm","rhehzhnlk","qggmtusbpnypjbxcisnoy","xengrpxq","knwvl","vdvhdvfztaxcyhjdugctrvkgulmbj","jsmzeshdnugttvppha","sfxkoexlvpihhfhfq","gfubyw","bl","uvpjsrqhwxdoeuc","ymyzwmsxcirfwhsafs","azusu","isl","ljdkfxvylzmspudjqqugddxrnhn","pjgfwoikxbybblja","zhjn","htjlnvbdfuzsjypkanhzg","oblhinaeguymmkleqeogwrzmbltl","mtndwtean","njnpajotnwihwedlefrukx","zhcnue","klgybdvijbdraoveascq","stbyc","upmawfjrcvyqphcgznqvlunehgm","xxfrzciifwxwzkqlhzi","bv","fhukhpkax","hpzca","uilnponlhvulz","krtfunvglmtcwasqlvhq","xfhfqdqnklxq","qaaoyjczafkqyncmmuqfj","ucxqf","idrkmks","esvmtdtyojpoccpnhmweleclk","eikqjjhbfnabekalchmoigbsvj","fndfnvpnmgcxjbfydgwiwpvst","jovaimqzyyputxnatlgvtflxmjwrgy","ys","fnxfo","pgsbqvig","jzfkmowocsuhipwvyavcimgslsa","jxejmmiwfrrknjyek","jbtpcxbxdbdpjztbvp","tphnrrekc","bdjntlktemditgnn","iwmovzzkfpvixarqckonwqhb","shufzxmpntnwkljqlayypynmnsvjnq","xtzyn","npjohbkidogcjbkpairnmmgslk","utwqphdxvmtvtjw","tvhkudu","ltvkvjigjqdjmfqihssvnnmxke","tvwhfeoxshl","gwmoxooqbgkuqhitqndhjknpoi","cugcsdfdgggnxbsrloqynmjisfxqcf","fqoxrbegbqfseoiqvevfjua","mducxmhhvuuoaxazhwpsuisush","kbsglfxut","hytiwcsrbwyj","n","xo","vlhyfvzcuuqrqymnzlbqwlwyk","hlcyxndydrxgebcjtgrjlfhhiqeh","coxufsaunxexcshrcqyjz","etwelbjtxilczjudlyziyosp","eblxqnyke","kexssggfp","hyxexwoosybkpifyohasxtk","wbtrhqdbwqyrvjizkgj","zuzgiuonhoaaqmafflrnsamdkefoki","l","axdaqveyksrmpc","hydpvnbhqpkvrcc","rezogqmazduvkcypiupyitmhrfmzki","cywlrzkl","ucnfeysd","vdztloyrjpzzylesddiewfemmbgfwe","ugjnsgqlp","xinbdvhzfykpmzpecgngelczoukzd","acqnnodwqzwlqnynvb","aooilovrtwqoaremskb","zkrcckbowwjxmfmdikfsbpyxrmgg","tmsfjgfjdjdbczcseznowpptr","wwqbevusanvcdzeshcglrzlarer","qyfopqgmglfiofw","ymlznwinj","dxeyeyejkosdpnub","fmgqdzvdtyethyynjjpbl","ykoyilcm","qlewoezxzmlhgypikhdl","ptopwfkziuttfeazrrglqdbszvr","zosncavdfjcsdnrxdp","eypstxtyxnnqnkmqptekdgpdqcdqn","wnnhai","ufolcgdeo","zcxbycuiqlvfpuslvv","alzzxhra","ykiatwmdigjxmxevdbd","xhc","cblx","nkmofftbapqitraxtfnilsfvwvpas","geg","ashrazctgqgwrm","lha","huhwnjqriyiweilhjzijuftlzp","rooillldcagevixecdxffz","zegpdvbmdgslagpvsjnmchspix","ywqhjouxx","lfgztikdpethoionvs","gwurhajbnavidhipzhxvlf","eelflqtsplanaahmxssqe","vbqhjdqajtvy","bsmqkkfmzszgtffpkpjouoxdmofivm","fhjbrzhroorglgbltarrvtjnkz","ckhb","ijrbjrqopmbveayra","p","yvizbmradwgxedumcbcktxublw","fxtsgerpchszrkfjpwwigy","mjgmpewjnlwijzx","rfbmlfacpec","nqmgha","swgsvdptrtepv","fboaiwtlfccdolpqutf","gpgbqii","lfsxwnhweveaaekybglvcluyeb","vagpvsdzqhwnlogzyje","agfqdph","pkwenkodtlbbdgvopqaeygphtlrmo"};
        
        //String[] man = {"Shogun", "KFC","Tapioca Express", "Burger King"};
        //String[] woman = {"KFC", "Shogun", "Burger King","apple"};
        

        String[] res = s1.findRestaurant(man,woman);
        for(int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }

        //test print [object]??
        // String a = "halp";
        // String[] b = {"yian","ahln"};

        // System.out.println(a);
        // System.out.println(b);

        long end = System.currentTimeMillis();       // 记录结束时间
        System.out.println("time: "+(end-start)+"ms");              // 相减得出运行时间

    }
}
