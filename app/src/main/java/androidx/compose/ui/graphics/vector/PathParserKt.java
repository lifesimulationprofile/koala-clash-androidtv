package androidx.compose.ui.graphics.vector;

import android.graphics.Path;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import coil.network.HttpException;
import java.util.List;
import kotlin.Unit;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class PathParserKt {
    public static final float[] PowersOfTen = {1.0f, 10.0f, 100.0f, 1000.0f, 10000.0f, 100000.0f, 1000000.0f, 1.0E7f, 1.0E8f, 1.0E9f, 1.0E10f};
    public static final long[] Mantissa64 = {-6499023860262858360L, -3512093806901185046L, -9112587656954322510L, -6779048552765515233L, -3862124672529506138L, -215969822234494768L, -7052510166537641086L, -4203951689744663454L, -643253593753441413L, -7319562523736982739L, -4537767136243840520L, -1060522901877412746L, -7580355841314464822L, -4863758783215693124L, -1468012460592228501L, -7835036815511224669L, -5182110000961642932L, -1865951482774665761L, -8083748704375247957L, -5492999862041672042L, -2254563809124702148L, -8326631408344020699L, -5796603242002637969L, -2634068034075909558L, -8563821548938525330L, -6093090917745768758L, -3004677628754823043L, -8795452545612846258L, -6382629663588669919L, -3366601061058449494L, -9021654690802612790L, -6665382345075878084L, -3720041912917459700L, -38366372719436721L, -6941508010590729807L, -4065198994811024355L, -469812725086392539L, -7211161980820077193L, -4402266457597708587L, -891147053569747830L, -7474495936122174250L, -4731433901725329908L, -1302606358729274481L, -7731658001846878407L, -5052886483881210105L, -1704422086424124727L, -7982792831656159810L, -5366805021142811859L, -2096820258001126919L, -8228041688891786181L, -5673366092687344822L, -2480021597431793123L, -8467542526035952558L, -5972742139117552794L, -2854241655469553088L, -8701430062309552536L, -6265101559459552766L, -3219690930897053053L, -8929835859451740015L, -6550608805887287114L, -3576574988931720989L, -9152888395723407474L, -6829424476226871438L, -3925094576856201394L, -294682202642863838L, -7101705404292871755L, -4265445736938701790L, -720121152745989333L, -7367604748107325189L, -4597819916706768583L, -1135588877456072824L, -7627272076051127371L, -4922404076636521310L, -1541319077368263733L, -7880853450996246689L, -5239380795317920458L, -1937539975720012668L, -8128491512466089774L, -5548928372155224313L, -2324474446766642487L, -8370325556870233411L, -5851220927660403859L, -2702340141148116920L, -8606491615858654931L, -6146428501395930760L, -3071349608317525546L, -8837122532839535322L, -6434717147622031249L, -3431710416100151157L, -9062348037703676329L, -6716249028702207507L, -3783625267450371480L, -117845565885576446L, -6991182506319567135L, -4127292114472071014L, -547429124662700864L, -7259672230555269896L, -4462904269766699466L, -966944318780986428L, -7521869226879198374L, -4790650515171610063L, -1376627125537124675L, -7777920981101784778L, -5110715207949843068L, -1776707991509915931L, -8027971522334779313L, -5423278384491086237L, -2167411962186469893L, -8272161504007625539L, -5728515861582144020L, -2548958808550292121L, -8510628282985014432L, -6026599335303880135L, -2921563150702462265L, -8743505996830120772L, -6317696477610263061L, -3285434578585440922L, -8970925639256982432L, -6601971030643840136L, -3640777769877412266L, -9193015133814464522L, -6879582898840692749L, -3987792605123478032L, -373054737976959636L, -7150688238876681629L, -4326674280168464132L, -796656831783192261L, -7415439547505577019L, -4657613415954583370L, -1210330751515841308L, -7673985747338482674L, -4980796165745715438L, -1614309188754756393L, -7926472270612804602L, -5296404319838617848L, -2008819381370884406L, -8173041140997884610L, -5604615407819967859L, -2394083241347571919L, -8413831053483314306L, -5905602798426754978L, -2770317479606055818L, -8648977452394866743L, -6199535797066195524L, -3137733727905356501L, -8878612607581929669L, -6486579741050024183L, -3496538657885142324L, -9102865688819295809L, -6766896092596731857L, -3846934097318526917L, -196981603220770742L, -7040642529654063570L, -4189117143640191558L, -624710411122851544L, -7307973034592864071L, -4523280274813692185L, -1042414325089727327L, -7569037980822161435L, -4849611457600313890L, -1450328303573004458L, -7823984217374209643L, -5168294253290374149L, -1848681798185579782L, -8072955151507069220L, -5479507920956448621L, -2237698882768172872L, -8316090829371189901L, -5783427518286599473L, -2617598379430861437L, -8553528014785370254L, -6080224000054324913L, -2988593981640518238L, -8785400266166405755L, -6370064314280619289L, -3350894374423386208L, -9011838011655698236L, -6653111496142234891L, -3704703351750405709L, -19193171260619233L, -6929524759678968877L, -4050219931171323192L, -451088895536766085L, -7199459587351560659L, -4387638465762062920L, -872862063775190746L, -7463067817500576073L, -4717148753448332187L, -1284749923383027329L, -7720497729755473937L, -5038936143766954517L, -1686984161281305242L, -7971894128441897632L, -5353181642124984136L, -2079791034228842266L, -8217398424034108273L, -5660062011615247437L, -2463391496091671392L, -8457148712698376476L, -5959749872445582691L, -2838001322129590460L, -8691279853972075893L, -6252413799037706963L, -3203831230369745799L, -8919923546622172981L, -6538218414850328322L, -3561087000135522498L, -9143208402725783417L, -6817324484979841368L, -3909969587797413806L, -275775966319379353L, -7089889006590693952L, -4250675239810979535L, -701658031336336515L, -7356065297226292178L, -4583395603105477319L, -1117558485454458744L, -7616003081050118571L, -4908317832885260310L, -1523711272679187483L, -7869848573065574033L, -5225624697904579637L, -1920344853953336643L, -8117744561361917258L, -5535494683275008668L, -2307682335666372931L, -8359830487432564938L, -5838102090863318269L, -2685941595151759932L, -8596242524610931813L, -6133617137336276863L, -3055335403242958174L, -8827113654667930715L, -6422206049907525490L, -3416071543957018958L, -9052573742614218705L, -6704031159840385477L, -3768352931373093942L, -98755145788979524L, -6979250993759194058L, -4112377723771604669L, -528786136287117932L, -7248020362820530564L, -4448339435098275301L, -948738275445456222L, -7510490449794491995L, -4776427043815727089L, -1358847786342270957L, -7766808894105001205L, -5096825099203863602L, -1759345355577441598L, -8017119874876982855L, -5409713825168840664L, -2150456263033662926L, -8261564192037121185L, -5715269221619013577L, -2532400508596379068L, -8500279345513818773L, -6013663163464885563L, -2905392935903719049L, -8733399612580906262L, -6305063497298744923L, -3269643353196043250L, -8961056123388608887L, -6589634135808373205L, -3625356651333078602L, -9183376934724255983L, -6867535149977932074L, -3972732919045027189L, -354230130378896082L, -7138922859127891907L, -4311967555482476980L, -778273425925708321L, -7403949918844649557L, -4643251380128424042L, -1192378206733142148L, -7662765406849295699L, -4966770740134231719L, -1596777406740401745L, -7915514906853832947L, -5282707615139903279L, -1991698500497491195L, -8162340590452013853L, -5591239719637629412L, -2377363631119648861L, -8403381297090862394L, -5892540602936190089L, -2753989735242849707L, -8638772612167862923L, -6186779746782440750L, -3121788665050663033L, -8868646943297746252L, -6474122660694794911L, -3480967307441105734L, -9093133594791772940L, -6754730975062328271L, -3831727700400522434L, -177973607073265139L, -7028762532061872568L, -4174267146649952806L, -606147914885053103L, -7296371474444240046L, -4508778324627912153L, -1024286887357502287L, -7557708332239520786L, -4835449396872013078L, -1432625727662628443L, -7812920107430224633L, -5154464115860392887L, -1831394126398103205L, -8062150356639896359L, -5466001927372482545L, -2220816390788215277L, -8305539271883716405L, -5770238071427257602L, -2601111570856684098L, -8543223759426509417L, -6067343680855748868L, -2972493582642298180L, -8775337516792518219L, -6357485877563259869L, -3335171328526686933L, -9002011107970261189L, -6640827866535438582L, -3689348814741910324L, Long.MIN_VALUE, -6917529027641081856L, -4035225266123964416L, -432345564227567616L, -7187745005283311616L, -4372995238176751616L, -854558029293551616L, -7451627795949551616L, -4702848726509551616L, -1266874889709551616L, -7709325833709551616L, -5024971273709551616L, -1669528073709551616L, -7960984073709551616L, -5339544073709551616L, -2062744073709551616L, -8206744073709551616L, -5646744073709551616L, -2446744073709551616L, -8446744073709551616L, -5946744073709551616L, -2821744073709551616L, -8681119073709551616L, -6239712823709551616L, -3187955011209551616L, -8910000909647051616L, -6525815118631426616L, -3545582879861895366L, -9133518327554766460L, -6805211891016070171L, -3894828845342699810L, -256850038250986858L, -7078060301547948643L, -4235889358507547899L, -683175679707046970L, -7344513827457986212L, -4568956265895094861L, -1099509313941480672L, -7604722348854507276L, -4894216917640746191L, -1506085128623544835L, -7858832233030797378L, -5211854272861108819L, -1903131822648998119L, -8106986416796705681L, -5522047002568494197L, -2290872734783229842L, -8349324486880600507L, -5824969590173362730L, -2669525969289315508L, -8585982758446904049L, -6120792429631242157L, -3039304518611664792L, -8817094351773372351L, -6409681921289327535L, -3400416383184271515L, -9042789267131251553L, -6691800565486676537L, -3753064688430957767L, -79644842111309304L, -6967307053960650171L, -4097447799023424810L, -510123730351893109L, -7236356359111015049L, -4433759430461380907L, -930513269649338230L, -7499099821171918250L, -4762188758037509908L, -1341049929119499481L, -7755685233340769032L, -5082920523248573386L, -1741964635633328828L, -8006256924911912374L, -5396135137712502563L, -2133482903713240300L, -8250955842461857044L, -5702008784649933400L, -2515824962385028846L, -8489919629131724885L, -6000713517987268202L, -2889205879056697349L, -8723282702051517699L, -6292417359137009220L, -3253835680493873621L, -8951176327949752869L, -6577284391509803182L, -3609919470959866074L, -9173728696990998152L, -6855474852811359786L, -3957657547586811828L, -335385916056126881L, -7127145225176161157L, -4297245513042813542L, -759870872876129024L, -7392448323188662496L, -4628874385558440216L, -1174406963520662366L, -7651533379841495835L, -4952730706374481889L, -1579227364540714458L, -7904546130479028392L, -5268996644671397586L, -1974559787411859078L, -8151628894773493780L, -5577850100039479321L, -2360626606621961247L, -8392920656779807636L, -5879464802547371641L, -2737644984756826647L, -8628557143114098510L, -6174010410465235234L, -3105826994654156138L, -8858670899299929442L, -6461652605697523899L, -3465379738694516970L, -9083391364325154962L, -6742553186979055799L, -3816505465296431844L, -158945813193151901L, -7016870160886801794L, -4159401682681114339L, -587566084924005019L, -7284757830718584993L, -4494261269970843337L, -1006140569036166268L, -7546366883288685774L, -4821272585683469313L, -1414904713676948737L, -7801844473689174817L, -5140619573684080617L, -1814088448677712867L, -8051334308064652398L, -5452481866653427593L, -2203916314889396588L, -8294976724446954723L, -5757034887131305500L, -2584607590486743971L, -8532908771695296838L, -6054449946191733143L, -2956376414312278525L, -8765264286586255934L, -6344894339805432014L, -3319431906329402113L, -8992173969096958177L, -6628531442943809817L, -3673978285252374367L, -9213765455923815836L, -6905520801477381891L, -4020214983419339459L, -413582710846786420L, -7176018221920323369L, -4358336758973016307L, -836234930288882479L, -7440175859071633406L, -4688533805412153853L, -1248981238337804412L, -7698142301602209614L, -5010991858575374113L, -1652053804791829737L, -7950062655635975442L, -5325892301117581398L, -2045679357969588844L, -8196078626372074883L, -5633412264537705700L, -2430079312244744221L, -8436328597794046994L, -5933724728815170839L, -2805469892591575644L, -8670947710510816634L, -6226998619711132888L, -3172062256211528206L, -8900067937773286985L, -6513398903789220827L, -3530062611309138130L, -9123818159709293187L, -6793086681209228580L, -3879672333084147821L, -237904397927796872L, -7066219276345954901L, -4221088077005055722L, -664674077828931749L, -7332950326284164199L, -4554501889427817345L, -1081441343357383777L, -7593429867239446717L, -4880101315621920492L, -1488440626100012711L, -7847804418953589800L, -5198069505264599346L, -1885900863153361279L, -8096217067111932656L, -5508585315462527915L, -2274045625900771990L, -8338807543829064350L, -5811823411358942533L, -2653093245771290262L, -8575712306248138270L, -6107954364382784934L, -3023256937051093263L, -8807064613298015146L, -6397144748195131028L, -3384744916816525881L, -9032994600651410532L, -6679557232386875260L, -3737760522056206171L, -60514634142869810L, -6955350673980375487L, -4082502324048081455L, -491441886632713915L, -7224680206786528053L, -4419164240055772162L, -912269281642327298L, -7487697328667536418L, -4747935642407032618L, -1323233534581402868L, -7744549986754458649L, -5069001465015685407L, -1724565812842218855L, -7995382660667468640L, -5382542307406947896L, -2116491865831296966L, -8240336443785642460L, -5688734536304665171L, -2499232151953443560L, -8479549122611984081L, -5987750384837592197L, -2873001962619602342L, -8713155254278333320L, -6279758049420528746L, -3238011543348273028L, -8941286242233752499L, -6564921784364802720L, -3594466212028615495L, -9164070410158966541L, -6843401994271320272L, -3942566474411762436L, -316522074587315140L, -7115355324258153819L, -4282508136895304370L, -741449152691742558L, -7380934748073420955L, -4614482416664388289L, -1156417002403097458L, -7640289654143017767L, -4938676049251384305L, -1561659043136842477L, -7893565929601608404L, -5255271393574622601L, -1957403223540890347L, -8140906042354138323L, -5564446534515285000L, -2343872149716718346L, -8382449121214030822L, -5866375383090150624L, -2721283210435300376L, -8618331034163144591L, -6161227774276542835L, -3089848699418290639L, -8848684464777513506L, -6449169562544503978L, -3449775934753242068L, -9073638986861858149L, -6730362715149934782L, -3801267375510030573L, -139898200960150313L, -7004965403241175802L, -4144520735624081848L, -568964901102714406L, -7273132090830278360L, -4479729095110460046L, -987975350460687153L, -7535013621679011327L, -4807081008671376254L, -1397165242411832414L, -7790757304148477115L, -5126760611758208489L, -1796764746270372707L, -8040506994060064798L, -5438947724147693094L, -2186998636757228463L, -8284403175614349646L, -5743817951090549153L, -2568086420435798537L, -8522583040413455942L, -6041542782089432023L, -2940242459184402125L, -8755180564631333184L, -6332289687361778576L, -3303676090774835316L, -8982326584375353929L, -6616222212041804507L, -3658591746624867729L, -9204148869281624187L, -6893500068174642330L, -4005189066790915008L, -394800315061255856L, -7164279224554366766L, -4343663012265570553L, -817892746904575288L, -7428711994456441411L, -4674203974643163860L, -1231068949876566920L, -7686947121313936181L, -4996997883215032323L, -1634561335591402499L, -7939129862385708418L, -5312226309554747619L, -2028596868516046619L, -8185402070463610993L};

    public static final void createGroupComponent(GroupComponent groupComponent, VectorGroup vectorGroup) {
        List list = vectorGroup.children;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            VectorNode vectorNode = (VectorNode) list.get(i);
            if (vectorNode instanceof VectorPath) {
                PathComponent pathComponent = new PathComponent();
                VectorPath vectorPath = (VectorPath) vectorNode;
                pathComponent.pathData = vectorPath.pathData;
                pathComponent.isPathDirty = true;
                pathComponent.invalidate();
                pathComponent.renderPath.internalPath.setFillType(vectorPath.pathFillType == 1 ? Path.FillType.EVEN_ODD : Path.FillType.WINDING);
                pathComponent.invalidate();
                pathComponent.invalidate();
                pathComponent.fill = vectorPath.fill;
                pathComponent.invalidate();
                pathComponent.fillAlpha = vectorPath.fillAlpha;
                pathComponent.invalidate();
                pathComponent.stroke = vectorPath.stroke;
                pathComponent.invalidate();
                pathComponent.strokeAlpha = vectorPath.strokeAlpha;
                pathComponent.invalidate();
                pathComponent.strokeLineWidth = vectorPath.strokeLineWidth;
                pathComponent.isStrokeDirty = true;
                pathComponent.invalidate();
                pathComponent.strokeLineCap = vectorPath.strokeLineCap;
                pathComponent.isStrokeDirty = true;
                pathComponent.invalidate();
                pathComponent.strokeLineJoin = vectorPath.strokeLineJoin;
                pathComponent.isStrokeDirty = true;
                pathComponent.invalidate();
                pathComponent.strokeLineMiter = vectorPath.strokeLineMiter;
                pathComponent.isStrokeDirty = true;
                pathComponent.invalidate();
                pathComponent.trimPathStart = vectorPath.trimPathStart;
                pathComponent.isTrimPathDirty = true;
                pathComponent.invalidate();
                pathComponent.trimPathEnd = vectorPath.trimPathEnd;
                pathComponent.isTrimPathDirty = true;
                pathComponent.invalidate();
                pathComponent.trimPathOffset = vectorPath.trimPathOffset;
                pathComponent.isTrimPathDirty = true;
                pathComponent.invalidate();
                groupComponent.insertAt(i, pathComponent);
            } else if (vectorNode instanceof VectorGroup) {
                GroupComponent groupComponent2 = new GroupComponent();
                VectorGroup vectorGroup2 = (VectorGroup) vectorNode;
                groupComponent2.name = vectorGroup2.name;
                groupComponent2.invalidate();
                groupComponent2.rotation = vectorGroup2.rotation;
                groupComponent2.isMatrixDirty = true;
                groupComponent2.invalidate();
                groupComponent2.scaleX = vectorGroup2.scaleX;
                groupComponent2.isMatrixDirty = true;
                groupComponent2.invalidate();
                groupComponent2.scaleY = vectorGroup2.scaleY;
                groupComponent2.isMatrixDirty = true;
                groupComponent2.invalidate();
                groupComponent2.translationX = vectorGroup2.translationX;
                groupComponent2.isMatrixDirty = true;
                groupComponent2.invalidate();
                groupComponent2.translationY = vectorGroup2.translationY;
                groupComponent2.isMatrixDirty = true;
                groupComponent2.invalidate();
                groupComponent2.pivotX = vectorGroup2.pivotX;
                groupComponent2.isMatrixDirty = true;
                groupComponent2.invalidate();
                groupComponent2.pivotY = vectorGroup2.pivotY;
                groupComponent2.isMatrixDirty = true;
                groupComponent2.invalidate();
                groupComponent2.clipPathData = vectorGroup2.clipPathData;
                groupComponent2.isClipPathDirty = true;
                groupComponent2.invalidate();
                createGroupComponent(groupComponent2, vectorGroup2);
                groupComponent.insertAt(i, groupComponent2);
            }
        }
    }

    public static final void drawArc(AndroidPath androidPath, double d, double d2, double d3, double d4, double d5, double d6, double d7, boolean z, boolean z2) {
        double d8;
        double d9;
        double d10 = d5;
        double d11 = (d7 / ((double) 180)) * 3.141592653589793d;
        double dCos = Math.cos(d11);
        double dSin = Math.sin(d11);
        double d12 = ((d2 * dSin) + (d * dCos)) / d10;
        double d13 = ((d2 * dCos) + ((-d) * dSin)) / d6;
        double d14 = ((d4 * dSin) + (d3 * dCos)) / d10;
        double d15 = ((d4 * dCos) + ((-d3) * dSin)) / d6;
        double d16 = d12 - d14;
        double d17 = d13 - d15;
        double d18 = 2;
        double d19 = (d12 + d14) / d18;
        double d20 = (d13 + d15) / d18;
        double d21 = (d17 * d17) + (d16 * d16);
        if (d21 == 0.0d) {
            return;
        }
        double d22 = (1.0d / d21) - 0.25d;
        if (d22 < 0.0d) {
            double dSqrt = (float) (Math.sqrt(d21) / 1.99999d);
            drawArc(androidPath, d, d2, d3, d4, d10 * dSqrt, d6 * dSqrt, d7, z, z2);
            return;
        }
        double dSqrt2 = Math.sqrt(d22);
        double d23 = d16 * dSqrt2;
        double d24 = dSqrt2 * d17;
        if (z == z2) {
            d8 = d19 - d24;
            d9 = d20 + d23;
        } else {
            d8 = d19 + d24;
            d9 = d20 - d23;
        }
        double dAtan2 = Math.atan2(d13 - d9, d12 - d8);
        double dAtan3 = Math.atan2(d15 - d9, d14 - d8) - dAtan2;
        if (z2 != (dAtan3 >= 0.0d)) {
            dAtan3 = dAtan3 > 0.0d ? dAtan3 - 6.283185307179586d : dAtan3 + 6.283185307179586d;
        }
        double d25 = d8 * d10;
        double d26 = d9 * d6;
        double d27 = (d25 * dCos) - (d26 * dSin);
        double d28 = (d26 * dCos) + (d25 * dSin);
        double d29 = 4;
        int iCeil = (int) Math.ceil(Math.abs((dAtan3 * d29) / 3.141592653589793d));
        double dCos2 = Math.cos(d11);
        double dSin2 = Math.sin(d11);
        double dCos3 = Math.cos(dAtan2);
        double dSin3 = Math.sin(dAtan2);
        double d30 = dAtan3;
        double d31 = -d10;
        double d32 = d31 * dCos2;
        double d33 = d6 * dSin2;
        double d34 = (d32 * dSin3) - (d33 * dCos3);
        double d35 = d31 * dSin2;
        double d36 = d6 * dCos2;
        double d37 = (dCos3 * d36) + (dSin3 * d35);
        double d38 = d30 / ((double) iCeil);
        double d39 = dAtan2;
        double d40 = d34;
        int i = 0;
        double d41 = d;
        double d42 = d37;
        double d43 = d2;
        while (i < iCeil) {
            double d44 = d39 + d38;
            double dSin4 = Math.sin(d44);
            double dCos4 = Math.cos(d44);
            int i2 = i;
            double d45 = (((d10 * dCos2) * dCos4) + d27) - (d33 * dSin4);
            int i3 = iCeil;
            double d46 = (d36 * dSin4) + (d10 * dSin2 * dCos4) + d28;
            double d47 = (d32 * dSin4) - (d33 * dCos4);
            double d48 = (dCos4 * d36) + (dSin4 * d35);
            double d49 = d44 - d39;
            double dTan = Math.tan(d49 / d18);
            double dSqrt3 = ((Math.sqrt(((3.0d * dTan) * dTan) + d29) - ((double) 1)) * Math.sin(d49)) / ((double) 3);
            androidPath.internalPath.cubicTo((float) ((d40 * dSqrt3) + d41), (float) ((d42 * dSqrt3) + d43), (float) (d45 - (dSqrt3 * d47)), (float) (d46 - (dSqrt3 * d48)), (float) d45, (float) d46);
            dSin2 = dSin2;
            d41 = d45;
            i = i2 + 1;
            d27 = d27;
            d29 = d29;
            d39 = d44;
            d42 = d48;
            d40 = d47;
            d43 = d46;
            iCeil = i3;
            d10 = d5;
        }
    }

    /* JADX WARN: Code duplicated, block: B:133:0x021b  */
    public static final long nextFloat(int i, int i2, String str) {
        char cCharAt;
        int i3;
        long j;
        char c;
        char c2;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        long j2;
        char c3;
        long j3;
        int iFloatToRawIntBits;
        int i9;
        int i10;
        int i11;
        long j4;
        long jFloatToRawIntBits;
        int i12;
        int iFloatToRawIntBits2;
        long j5 = 4294967295L;
        if (i != i2) {
            char cCharAt2 = str.charAt(i);
            boolean z = cCharAt2 == '-';
            if (z) {
                i3 = i + 1;
                if (i3 != i2) {
                    cCharAt = str.charAt(i3);
                    if (((char) (cCharAt - '0')) >= '\n' && cCharAt != '.') {
                        j4 = ((long) i3) << 32;
                        iFloatToRawIntBits2 = Float.floatToRawIntBits(Float.NaN);
                    }
                    return j4 | jFloatToRawIntBits;
                }
                j4 = ((long) i3) << 32;
                iFloatToRawIntBits2 = Float.floatToRawIntBits(Float.NaN);
            } else {
                cCharAt = cCharAt2;
                i3 = i;
            }
            int length = str.length();
            int i13 = i3;
            long j6 = 0;
            while (true) {
                if (i13 == i2) {
                    j = j5;
                    break;
                }
                j = j5;
                int i14 = cCharAt - '0';
                if (((char) i14) >= '\n') {
                    break;
                }
                j6 = (j6 * 10) + ((long) i14);
                i13++;
                cCharAt = i13 < length ? str.charAt(i13) : (char) 0;
                j5 = j;
            }
            int i15 = i13 - i3;
            char c4 = '0';
            if (i13 == i2 || cCharAt != '.') {
                c = ' ';
                c2 = 1;
                i4 = i13;
                i5 = i4;
                i6 = 0;
            } else {
                int i16 = i13 + 1;
                c = ' ';
                i4 = i16;
                while (true) {
                    c2 = 1;
                    if (i2 - i4 < 4) {
                        i12 = i16;
                        break;
                    }
                    i12 = i16;
                    long jCharAt = ((long) str.charAt(i4)) | (((long) str.charAt(i4 + 1)) << 16) | (((long) str.charAt(i4 + 2)) << 32) | (((long) str.charAt(i4 + 3)) << 48);
                    long j7 = jCharAt - 13511005043687472L;
                    int i17 = (((jCharAt + 19703549022044230L) | j7) & (-35747867511423104L)) != 0 ? -1 : (int) ((j7 * 281475406208040961L) >>> 48);
                    if (i17 < 0) {
                        break;
                    }
                    j6 = (j6 * 10000) + ((long) i17);
                    i4 += 4;
                    i16 = i12;
                }
                char cCharAt3 = i4 < length ? str.charAt(i4) : (char) 0;
                loop2: while (true) {
                    cCharAt = cCharAt3;
                    while (true) {
                        if (i4 == i2) {
                            break loop2;
                        }
                        int i18 = cCharAt - '0';
                        if (((char) i18) >= '\n') {
                            break loop2;
                        }
                        j6 = (j6 * 10) + ((long) i18);
                        i4++;
                        if (i4 < length) {
                            break;
                        }
                        cCharAt = 0;
                    }
                    cCharAt3 = str.charAt(i4);
                }
                i6 = i12 - i4;
                i15 -= i6;
                i5 = i12;
            }
            if (i15 == 0) {
                j4 = ((long) i4) << c;
                jFloatToRawIntBits = ((long) Float.floatToRawIntBits(Float.NaN)) & j;
                return j4 | jFloatToRawIntBits;
            }
            if ((cCharAt | ' ') == 101) {
                i7 = i4 + 1;
                char cCharAt4 = i7 < length ? str.charAt(i7) : (char) 0;
                char c5 = cCharAt4 == '-' ? c2 : (char) 0;
                if (c5 != 0 || cCharAt4 == '+') {
                    i7 = i4 + 2;
                }
                char cCharAt5 = str.charAt(i7);
                i8 = 0;
                while (true) {
                    if (i7 == i2) {
                        i11 = i6;
                        break;
                    }
                    int i19 = cCharAt5 - '0';
                    i11 = i6;
                    if (((char) i19) >= '\n') {
                        break;
                    }
                    if (i8 < 1024) {
                        i8 = (i8 * 10) + i19;
                    }
                    i7++;
                    cCharAt5 = i7 < length ? str.charAt(i7) : (char) 0;
                    i6 = i11;
                }
                if (c5 != 0) {
                    i8 = -i8;
                }
                i6 = i11 + i8;
            } else {
                i7 = i4;
                i8 = 0;
            }
            int i20 = 19;
            if (i15 > 19) {
                char cCharAt6 = str.charAt(i3);
                int i21 = i3;
                while (true) {
                    if (i7 != i2) {
                        char c6 = c4;
                        if (cCharAt6 != c6 && cCharAt6 != '.') {
                            i9 = 19;
                            break;
                        }
                        if (cCharAt6 == c6) {
                            i15--;
                        }
                        int i22 = i21 + 1;
                        i21 = i22;
                        cCharAt6 = i22 < length ? str.charAt(i22) : (char) 0;
                        i20 = 19;
                        c4 = '0';
                    } else {
                        i9 = i20;
                        break;
                    }
                }
                if (i15 > i9) {
                    char cCharAt7 = str.charAt(i3);
                    long j8 = 0;
                    while (true) {
                        i10 = i3;
                        if (i3 == i13 || Long.compare(j8 ^ Long.MIN_VALUE, -8223372036854775808L) >= 0) {
                            break;
                        }
                        j8 = (j8 * 10) + ((long) (cCharAt7 - '0'));
                        i3 = i10 + 1;
                        cCharAt7 = i3 < length ? str.charAt(i3) : (char) 0;
                    }
                    if (Long.compare(j8 ^ Long.MIN_VALUE, -8223372036854775808L) >= 0) {
                        i6 = (i13 - i10) + i8;
                    } else {
                        char cCharAt8 = str.charAt(i5);
                        int i23 = i5;
                        while (i23 != i4 && Long.compare(j8 ^ Long.MIN_VALUE, -8223372036854775808L) < 0) {
                            j8 = (j8 * 10) + ((long) (cCharAt8 - '0'));
                            i23++;
                            cCharAt8 = i23 < length ? str.charAt(i23) : (char) 0;
                        }
                        i6 = (i5 - i23) + i8;
                    }
                    j2 = j8;
                    c3 = c2;
                } else {
                    j2 = j6;
                    c3 = 0;
                }
            } else {
                j2 = j6;
                c3 = 0;
            }
            if (-10 <= i6 && i6 < 11 && c3 == 0 && Long.compare(j2 ^ Long.MIN_VALUE, -9223372036837998592L) <= 0) {
                float f = j2;
                float[] fArr = PowersOfTen;
                float f2 = i6 < 0 ? f / fArr[-i6] : f * fArr[i6];
                if (z) {
                    f2 = -f2;
                }
                j3 = ((long) i7) << c;
                iFloatToRawIntBits = Float.floatToRawIntBits(f2);
            } else if (j2 == 0) {
                j3 = ((long) i7) << c;
                iFloatToRawIntBits = Float.floatToRawIntBits(z ? -0.0f : 0.0f);
            } else if (-126 > i6 || i6 >= 128) {
                j3 = ((long) i7) << c;
                iFloatToRawIntBits = Float.floatToRawIntBits(Float.parseFloat(str.substring(i, i7)));
            } else {
                long j9 = Mantissa64[i6 + 325];
                int iNumberOfLeadingZeros = Long.numberOfLeadingZeros(j2);
                long j10 = j2 << iNumberOfLeadingZeros;
                long j11 = j10 & j;
                long j12 = j10 >>> c;
                long j13 = j9 & j;
                long j14 = j9 >>> c;
                long j15 = j12 * j14;
                long j16 = j14 * j11;
                long j17 = j15 + ((((j12 * j13) + ((j11 * j13) >>> c)) + (j16 & j)) >>> c) + (j16 >>> c);
                int i24 = (int) (j17 >>> 63);
                long j18 = j17 >>> (i24 + 9);
                int i25 = iNumberOfLeadingZeros + (i24 ^ 1);
                long j19 = j17 & 511;
                if (j19 == 511 || (j19 == 0 && (3 & j18) == 1)) {
                    j3 = ((long) i7) << c;
                    iFloatToRawIntBits = Float.floatToRawIntBits(Float.parseFloat(str.substring(i, i7)));
                } else {
                    long j20 = (j18 + 1) >>> c2;
                    if (j20 >= 9007199254740992L) {
                        i25--;
                        j20 = 4503599627370496L;
                    }
                    long j21 = j20 & (-4503599627370497L);
                    long j22 = ((((((long) i6) * 217706) >> 16) + ((long) 1024)) + ((long) 63)) - ((long) i25);
                    if (j22 < 1 || j22 > 2046) {
                        j3 = ((long) i7) << c;
                        iFloatToRawIntBits = Float.floatToRawIntBits(Float.parseFloat(str.substring(i, i7)));
                    } else {
                        j3 = ((long) i7) << c;
                        iFloatToRawIntBits = Float.floatToRawIntBits((float) Double.longBitsToDouble((j22 << 52) | j21 | (z ? Long.MIN_VALUE : 0L)));
                    }
                }
            }
            return j3 | (((long) iFloatToRawIntBits) & j);
        }
        j4 = ((long) i) << 32;
        iFloatToRawIntBits2 = Float.floatToRawIntBits(Float.NaN);
        jFloatToRawIntBits = ((long) iFloatToRawIntBits2) & 4294967295L;
        return j4 | jFloatToRawIntBits;
    }

    public static final VectorPainter rememberVectorPainter(ImageVector imageVector, GapComposer gapComposer) {
        Density density = (Density) gapComposer.consume(CompositionLocalsKt.LocalDensity);
        boolean zChanged = gapComposer.changed((((long) Float.floatToRawIntBits(density.getDensity())) & 4294967295L) | (((long) Float.floatToRawIntBits(imageVector.genId)) << 32));
        Object objRememberedValue = gapComposer.rememberedValue();
        if (zChanged || objRememberedValue == Composer$Companion.Empty) {
            GroupComponent groupComponent = new GroupComponent();
            createGroupComponent(groupComponent, imageVector.root);
            Unit unit = Unit.INSTANCE;
            long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(density.mo92toPx0680j_4(imageVector.defaultWidth))) << 32) | (((long) Float.floatToRawIntBits(density.mo92toPx0680j_4(imageVector.defaultHeight))) & 4294967295L);
            float fIntBitsToFloat = imageVector.viewportWidth;
            float fIntBitsToFloat2 = imageVector.viewportHeight;
            if (Float.isNaN(fIntBitsToFloat)) {
                fIntBitsToFloat = Float.intBitsToFloat((int) (jFloatToRawIntBits >> 32));
            }
            if (Float.isNaN(fIntBitsToFloat2)) {
                fIntBitsToFloat2 = Float.intBitsToFloat((int) (jFloatToRawIntBits & 4294967295L));
            }
            long jFloatToRawIntBits2 = (((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (4294967295L & ((long) Float.floatToRawIntBits(fIntBitsToFloat2)));
            VectorPainter vectorPainter = new VectorPainter(groupComponent);
            String str = imageVector.name;
            long j = imageVector.tintColor;
            BlendModeColorFilter blendModeColorFilter = j != 16 ? new BlendModeColorFilter(imageVector.tintBlendMode, j) : null;
            boolean z = imageVector.autoMirror;
            vectorPainter.size$delegate.setValue(new Size(jFloatToRawIntBits));
            vectorPainter.autoMirror$delegate.setValue(Boolean.valueOf(z));
            VectorComponent vectorComponent = vectorPainter.vector;
            vectorComponent.intrinsicColorFilter$delegate.setValue(blendModeColorFilter);
            vectorComponent.viewportSize$delegate.setValue(new Size(jFloatToRawIntBits2));
            vectorComponent.name = str;
            gapComposer.updateRememberedValue(vectorPainter);
            objRememberedValue = vectorPainter;
        }
        return (VectorPainter) objRememberedValue;
    }

    public static final void toPath(List list, AndroidPath androidPath) {
        PathNode pathNode;
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        List list2 = list;
        Path path = androidPath.internalPath;
        Path path2 = androidPath.internalPath;
        Path.FillType fillType = path.getFillType();
        Path.FillType fillType2 = Path.FillType.EVEN_ODD;
        boolean z = fillType == fillType2;
        path2.rewind();
        if (!z) {
            fillType2 = Path.FillType.WINDING;
        }
        path2.setFillType(fillType2);
        PathNode pathNode2 = list2.isEmpty() ? PathNode.Close.INSTANCE : (PathNode) list2.get(0);
        int size = list2.size();
        float f9 = 0.0f;
        int i = 0;
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        float f15 = 0.0f;
        while (i < size) {
            PathNode pathNode3 = (PathNode) list2.get(i);
            if (pathNode3 instanceof PathNode.Close) {
                path2.close();
                path2 = path2;
                size = size;
                f9 = f9;
                i = i;
                pathNode = pathNode3;
                f10 = f14;
                f12 = f10;
                f11 = f15;
                f13 = f11;
            } else {
                if (pathNode3 instanceof PathNode.RelativeMoveTo) {
                    PathNode.RelativeMoveTo relativeMoveTo = (PathNode.RelativeMoveTo) pathNode3;
                    float f16 = relativeMoveTo.dx;
                    f12 += f16;
                    float f17 = relativeMoveTo.dy;
                    f13 += f17;
                    path2.rMoveTo(f16, f17);
                    path2 = path2;
                    f14 = f12;
                    f15 = f13;
                } else if (pathNode3 instanceof PathNode.MoveTo) {
                    PathNode.MoveTo moveTo = (PathNode.MoveTo) pathNode3;
                    float f18 = moveTo.x;
                    float f19 = moveTo.y;
                    path2.moveTo(f18, f19);
                    f13 = f19;
                    f15 = f13;
                    f12 = f18;
                    f14 = f12;
                } else if (pathNode3 instanceof PathNode.RelativeLineTo) {
                    PathNode.RelativeLineTo relativeLineTo = (PathNode.RelativeLineTo) pathNode3;
                    float f20 = relativeLineTo.dy;
                    float f21 = relativeLineTo.dx;
                    path2.rLineTo(f21, f20);
                    f12 += f21;
                    f13 += f20;
                } else if (pathNode3 instanceof PathNode.LineTo) {
                    PathNode.LineTo lineTo = (PathNode.LineTo) pathNode3;
                    float f22 = lineTo.y;
                    float f23 = lineTo.x;
                    path2.lineTo(f23, f22);
                    f12 = f23;
                    f13 = f22;
                } else if (pathNode3 instanceof PathNode.RelativeHorizontalTo) {
                    float f24 = ((PathNode.RelativeHorizontalTo) pathNode3).dx;
                    path2.rLineTo(f24, f9);
                    f12 += f24;
                } else if (pathNode3 instanceof PathNode.HorizontalTo) {
                    float f25 = ((PathNode.HorizontalTo) pathNode3).x;
                    path2.lineTo(f25, f13);
                    f12 = f25;
                } else {
                    if (pathNode3 instanceof PathNode.RelativeVerticalTo) {
                        f8 = ((PathNode.RelativeVerticalTo) pathNode3).dy;
                        path2.rLineTo(f9, f8);
                    } else if (pathNode3 instanceof PathNode.VerticalTo) {
                        float f26 = ((PathNode.VerticalTo) pathNode3).y;
                        path2.lineTo(f12, f26);
                        f13 = f26;
                    } else if (pathNode3 instanceof PathNode.RelativeCurveTo) {
                        PathNode.RelativeCurveTo relativeCurveTo = (PathNode.RelativeCurveTo) pathNode3;
                        path2.rCubicTo(relativeCurveTo.dx1, relativeCurveTo.dy1, relativeCurveTo.dx2, relativeCurveTo.dy2, relativeCurveTo.dx3, relativeCurveTo.dy3);
                        f10 = relativeCurveTo.dx2 + f12;
                        f11 = relativeCurveTo.dy2 + f13;
                        f12 += relativeCurveTo.dx3;
                        f8 = relativeCurveTo.dy3;
                    } else {
                        if (pathNode3 instanceof PathNode.CurveTo) {
                            PathNode.CurveTo curveTo = (PathNode.CurveTo) pathNode3;
                            path2.cubicTo(curveTo.x1, curveTo.y1, curveTo.x2, curveTo.y2, curveTo.x3, curveTo.y3);
                            f10 = curveTo.x2;
                            f11 = curveTo.y2;
                            f4 = curveTo.x3;
                            f5 = curveTo.y3;
                        } else if (pathNode3 instanceof PathNode.RelativeReflectiveCurveTo) {
                            if (pathNode2.isCurve) {
                                f7 = f13 - f11;
                                f6 = f12 - f10;
                            } else {
                                f6 = f9;
                                f7 = f6;
                            }
                            PathNode.RelativeReflectiveCurveTo relativeReflectiveCurveTo = (PathNode.RelativeReflectiveCurveTo) pathNode3;
                            path2.rCubicTo(f6, f7, relativeReflectiveCurveTo.dx1, relativeReflectiveCurveTo.dy1, relativeReflectiveCurveTo.dx2, relativeReflectiveCurveTo.dy2);
                            f10 = relativeReflectiveCurveTo.dx1 + f12;
                            f11 = relativeReflectiveCurveTo.dy1 + f13;
                            f12 += relativeReflectiveCurveTo.dx2;
                            f8 = relativeReflectiveCurveTo.dy2;
                        } else if (pathNode3 instanceof PathNode.ReflectiveCurveTo) {
                            if (pathNode2.isCurve) {
                                float f27 = 2;
                                f12 = (f12 * f27) - f10;
                                f13 = (f27 * f13) - f11;
                            }
                            PathNode.ReflectiveCurveTo reflectiveCurveTo = (PathNode.ReflectiveCurveTo) pathNode3;
                            path2.cubicTo(f12, f13, reflectiveCurveTo.x1, reflectiveCurveTo.y1, reflectiveCurveTo.x2, reflectiveCurveTo.y2);
                            f10 = reflectiveCurveTo.x1;
                            f11 = reflectiveCurveTo.y1;
                            f4 = reflectiveCurveTo.x2;
                            f5 = reflectiveCurveTo.y2;
                        } else if (pathNode3 instanceof PathNode.RelativeQuadTo) {
                            PathNode.RelativeQuadTo relativeQuadTo = (PathNode.RelativeQuadTo) pathNode3;
                            float f28 = relativeQuadTo.dy2;
                            float f29 = relativeQuadTo.dx2;
                            float f30 = relativeQuadTo.dy1;
                            float f31 = relativeQuadTo.dx1;
                            path2.rQuadTo(f31, f30, f29, f28);
                            float f32 = f31 + f12;
                            float f33 = f30 + f13;
                            f12 += f29;
                            f13 += f28;
                            f10 = f32;
                            f11 = f33;
                        } else {
                            if (pathNode3 instanceof PathNode.QuadTo) {
                                PathNode.QuadTo quadTo = (PathNode.QuadTo) pathNode3;
                                float f34 = quadTo.y2;
                                float f35 = quadTo.x2;
                                float f36 = quadTo.y1;
                                f3 = quadTo.x1;
                                path2.quadTo(f3, f36, f35, f34);
                                f13 = f34;
                                f12 = f35;
                                f11 = f36;
                            } else if (pathNode3 instanceof PathNode.RelativeReflectiveQuadTo) {
                                if (pathNode2.isQuad) {
                                    f = f12 - f10;
                                    f2 = f13 - f11;
                                } else {
                                    f = f9;
                                    f2 = f;
                                }
                                PathNode.RelativeReflectiveQuadTo relativeReflectiveQuadTo = (PathNode.RelativeReflectiveQuadTo) pathNode3;
                                float f37 = relativeReflectiveQuadTo.dy;
                                float f38 = relativeReflectiveQuadTo.dx;
                                path2.rQuadTo(f, f2, f38, f37);
                                f3 = f + f12;
                                float f39 = f2 + f13;
                                f12 += f38;
                                f13 += f37;
                                f11 = f39;
                            } else if (pathNode3 instanceof PathNode.ReflectiveQuadTo) {
                                if (pathNode2.isQuad) {
                                    float f40 = 2;
                                    f12 = (f12 * f40) - f10;
                                    f13 = (f40 * f13) - f11;
                                }
                                PathNode.ReflectiveQuadTo reflectiveQuadTo = (PathNode.ReflectiveQuadTo) pathNode3;
                                float f41 = reflectiveQuadTo.y;
                                float f42 = reflectiveQuadTo.x;
                                path2.quadTo(f12, f13, f42, f41);
                                path2 = path2;
                                size = size;
                                f9 = f9;
                                i = i;
                                f11 = f13;
                                pathNode = pathNode3;
                                f13 = f41;
                                f10 = f12;
                                f12 = f42;
                            } else if (pathNode3 instanceof PathNode.RelativeArcTo) {
                                PathNode.RelativeArcTo relativeArcTo = (PathNode.RelativeArcTo) pathNode3;
                                float f43 = relativeArcTo.arcStartDx + f12;
                                float f44 = relativeArcTo.arcStartDy + f13;
                                size = size;
                                f9 = 0.0f;
                                path2 = path2;
                                i = i;
                                drawArc(androidPath, f12, f13, f43, f44, relativeArcTo.horizontalEllipseRadius, relativeArcTo.verticalEllipseRadius, relativeArcTo.theta, relativeArcTo.isMoreThanHalf, relativeArcTo.isPositiveArc);
                                f10 = f43;
                                f12 = f10;
                                f11 = f44;
                                f13 = f11;
                                pathNode = pathNode3;
                            } else {
                                path2 = path2;
                                size = size;
                                f9 = f9;
                                i = i;
                                if (!(pathNode3 instanceof PathNode.ArcTo)) {
                                    throw new HttpException();
                                }
                                PathNode.ArcTo arcTo = (PathNode.ArcTo) pathNode3;
                                float f45 = arcTo.arcStartY;
                                float f46 = arcTo.arcStartX;
                                pathNode = pathNode3;
                                drawArc(androidPath, f12, f13, f46, f45, arcTo.horizontalEllipseRadius, arcTo.verticalEllipseRadius, arcTo.theta, arcTo.isMoreThanHalf, arcTo.isPositiveArc);
                                f11 = f45;
                                f13 = f11;
                                f10 = f46;
                                f12 = f10;
                            }
                            size = size;
                            f9 = f9;
                            i = i;
                            pathNode = pathNode3;
                            f10 = f3;
                        }
                        f13 = f5;
                        f12 = f4;
                    }
                    f13 += f8;
                }
                pathNode = pathNode3;
            }
            i++;
            list2 = list;
            size = size;
            path2 = path2;
            pathNode2 = pathNode;
            f9 = f9;
        }
    }
}
