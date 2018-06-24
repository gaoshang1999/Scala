package leetcode.dp

object P646 {
  def findLongestChain(pairs: Array[Array[Int]]): Int = {
 
    val p = pairs.sortWith( (a, b) => a(1) < b(1))
    
    println(p.map(_.mkString("\t")).mkString(" | "));
    
    val n = p.length;
    if (n == 0 ) return 0
    
    var max = 1;
    for(i <- 0  to n-1){
       var a = p(i)
       println()
       println(a.mkString("\t"))
       
       var l = 1
       for( j <- i to n-1){
          if( p(j)(0) > a(1) ){
             l = l+1
             a = p(j)
             println(a.mkString("\t"))
             max = max.max(l)
          }
       }
    }   
        
    return max;
  }

  def main(args: Array[String]) {    
    var a  = Array( Array(1,2), Array(3,4) , Array(2,3)  )
    
    println(findLongestChain(a))
    
    a = Array(Array(7,9),Array(4,5),Array(7,9),Array(-7,-1),Array(0,10),Array(3,10),Array(3,6),Array(2,3))
    println(findLongestChain(a))    
    
    a = Array(Array(-787,347),Array(-548,-190),Array(362,857),Array(999,1000),Array(262,794),Array(-561,657),Array(-237,950),Array(147,592),Array(360,542),Array(-554,510),Array(209,977),Array(-718,4),Array(-279,-216),Array(976,991),Array(256,651),Array(-385,-262),Array(-529,522),Array(507,753),Array(-496,-476),Array(-909,-742),Array(696,866),Array(-567,24),Array(-250,899),Array(185,395),Array(440,575),Array(-824,428),Array(-908,157),Array(478,971),Array(-500,87),Array(-319,812),Array(-910,-529),Array(-817,703),Array(636,978),Array(724,727),Array(-515,160),Array(-586,621),Array(-313,146),Array(443,867),Array(-376,840),Array(685,777),Array(788,848),Array(-557,628),Array(-837,442),Array(-49,426),Array(592,636),Array(591,881),Array(568,780),Array(845,860),Array(159,598),Array(-176,444),Array(-866,-497),Array(-11,769),Array(-564,969),Array(-415,934),Array(-966,-73),Array(193,409),Array(-689,169),Array(132,150),Array(-714,928),Array(645,715),Array(-745,284),Array(295,481),Array(-941,-846),Array(-929,532),Array(113,724),Array(260,424),Array(-95,-71),Array(298,892),Array(-625,264),Array(-590,125),Array(-209,391),Array(427,734),Array(-353,742),Array(406,945),Array(-424,955),Array(-903,341),Array(-793,-284),Array(871,943),Array(-278,955),Array(46,218),Array(735,815),Array(-730,-663),Array(-477,-157),Array(-506,428),Array(770,823),Array(-527,299),Array(580,622),Array(-280,44),Array(15,710),Array(-310,124),Array(-318,-176),Array(-796,-146),Array(459,877),Array(852,955),Array(-424,37),Array(275,470),Array(-313,449),Array(-260,-228),Array(-90,450),Array(714,983),Array(304,774),Array(707,715),Array(-168,-68),Array(-501,274),Array(234,840),Array(-695,619),Array(373,896),Array(643,777),Array(-485,662),Array(-402,579),Array(970,996),Array(343,637),Array(785,944),Array(-666,259),Array(-56,611),Array(677,733),Array(-152,965),Array(455,534),Array(611,843),Array(-660,758),Array(-744,-115),Array(180,338),Array(-412,-232),Array(-536,691),Array(-781,-684),Array(128,538),Array(645,695),Array(537,546),Array(-781,-33),Array(865,936),Array(-247,254),Array(14,55),Array(-118,441),Array(-147,819),Array(-406,-227),Array(-188,588),Array(883,886),Array(-501,885),Array(-725,18),Array(458,838),Array(-779,-80),Array(-290,40),Array(885,935),Array(-402,777),Array(-655,901),Array(870,894),Array(172,693),Array(-164,-19),Array(477,575),Array(-326,-282),Array(54,811),Array(-915,656),Array(-728,697),Array(39,467),Array(-54,496),Array(819,846),Array(-299,853),Array(-20,815),Array(-858,280),Array(-205,35),Array(-155,398),Array(968,977),Array(-807,13),Array(-390,-287),Array(16,260),Array(974,997),Array(208,254),Array(318,826),Array(223,270),Array(-763,154),Array(-331,972),Array(-765,-396),Array(-566,934),Array(-601,580),Array(-51,647),Array(826,890),Array(-761,332),Array(963,1000),Array(-345,622),Array(-22,221),Array(-722,-344),Array(-165,563),Array(-55,833),Array(595,998),Array(373,663),Array(298,866),Array(-831,-554),Array(87,979),Array(154,890),Array(-279,-135),Array(88,181),Array(635,920),Array(465,965),Array(62,863),Array(952,956),Array(-166,531),Array(501,756),Array(984,990),Array(97,678),Array(-472,62),Array(873,921),Array(-436,872),Array(697,758),Array(-200,10),Array(-22,788),Array(364,577),Array(-1000,-633),Array(-537,49),Array(-501,484),Array(124,262),Array(161,249),Array(987,993),Array(-404,633),Array(423,769),Array(-583,-368),Array(959,970),Array(-520,383),Array(-904,-512),Array(-829,-554),Array(652,926),Array(-811,-244),Array(-907,-369),Array(860,951),Array(-730,397),Array(-885,-776),Array(-75,836),Array(408,946),Array(493,661),Array(-427,892),Array(-442,681),Array(-286,752),Array(869,936),Array(-124,-118),Array(-785,-174),Array(641,689),Array(-795,-600),Array(-457,909),Array(-657,193),Array(-26,140),Array(-329,736),Array(-829,-423),Array(842,882),Array(945,988),Array(768,949),Array(-762,-326),Array(149,997),Array(-595,-527),Array(-439,907),Array(338,932),Array(-990,-633),Array(336,976),Array(-499,-173),Array(226,312),Array(-134,501),Array(-869,571),Array(418,831),Array(305,694),Array(-651,-286),Array(-95,418),Array(-553,416),Array(809,840),Array(497,808),Array(-519,949),Array(62,845),Array(-919,-67),Array(114,875),Array(-953,-916),Array(170,923),Array(121,719),Array(10,698),Array(-592,709),Array(-364,128),Array(-905,44),Array(800,912),Array(910,990),Array(-315,213),Array(848,951),Array(-940,800),Array(-354,133),Array(127,635),Array(-767,-485),Array(515,552),Array(907,955),Array(62,804),Array(766,808),Array(291,442),Array(-588,-299),Array(258,273),Array(-930,516),Array(-187,999),Array(941,967),Array(632,764),Array(897,946),Array(-998,-994),Array(-1000,216),Array(924,969),Array(-840,558),Array(208,813),Array(-964,178),Array(-572,-217),Array(-704,16),Array(-295,-65),Array(-373,861),Array(586,603),Array(-725,295),Array(-595,349),Array(-615,-433),Array(851,973),Array(-431,163),Array(-436,981),Array(-897,-495),Array(-801,-348),Array(-772,950),Array(-106,38),Array(-601,23),Array(-493,914),Array(-986,-13),Array(45,900),Array(-945,-350),Array(-538,159),Array(675,766),Array(614,756),Array(-247,504),Array(-131,642),Array(-431,587),Array(-259,996),Array(290,797),Array(41,197),Array(-707,661),Array(141,871),Array(43,834),Array(641,962),Array(147,1000),Array(-895,-87),Array(848,953),Array(-810,334),Array(-297,800),Array(-147,756),Array(430,629),Array(-759,-753),Array(-156,844),Array(-943,605),Array(-104,29),Array(182,778),Array(-773,-264),Array(198,696),Array(150,624),Array(-630,-540),Array(-890,483),Array(-863,806),Array(-77,37),Array(160,220),Array(805,859),Array(510,896),Array(-80,768),Array(155,486),Array(658,789),Array(-425,-254),Array(498,927),Array(741,892),Array(744,969),Array(-455,276),Array(-651,494),Array(108,872),Array(932,979),Array(-330,915),Array(-139,677),Array(-852,318),Array(446,769),Array(-583,901),Array(69,204),Array(-708,-9),Array(835,933),Array(304,893),Array(-904,481),Array(37,552),Array(-1,850),Array(-545,855),Array(179,212),Array(-737,-726),Array(-380,416),Array(-82,99),Array(-365,174),Array(-960,-815),Array(687,899),Array(-991,-938),Array(-948,-654),Array(-314,667),Array(-719,574),Array(365,837),Array(-432,316),Array(594,695),Array(68,940),Array(-479,145),Array(-933,-355),Array(340,452),Array(-807,-561),Array(-834,-740),Array(568,862),Array(433,509),Array(-407,566),Array(657,956),Array(56,443),Array(637,913),Array(404,780),Array(-382,925),Array(-830,992),Array(20,288),Array(-60,126),Array(485,540),Array(242,478),Array(845,935),Array(335,471),Array(-728,2),Array(-805,-563),Array(-69,242),Array(361,909),Array(-336,586),Array(719,989),Array(-227,188),Array(-759,-204),Array(-754,916),Array(717,972),Array(-87,431),Array(-868,-135),Array(23,382),Array(-40,961),Array(-618,979),Array(-561,458),Array(547,758),Array(-633,486),Array(349,743),Array(632,876),Array(-679,-615),Array(782,846),Array(-84,450),Array(626,691),Array(806,974),Array(120,796),Array(509,945),Array(73,576),Array(607,658),Array(-446,925),Array(818,945),Array(240,298),Array(-808,-669),Array(-469,583),Array(521,852),Array(-713,423),Array(625,861),Array(813,990),Array(995,999),Array(-997,833),Array(-540,760),Array(315,859),Array(-507,-230),Array(499,599),Array(-780,159),Array(999,1000),Array(913,979),Array(919,944),Array(148,458),Array(63,833),Array(129,280),Array(-42,186),Array(409,529),Array(485,979),Array(818,976),Array(-766,913),Array(-944,-193),Array(788,829),Array(520,717),Array(-934,-204),Array(-570,581),Array(707,899),Array(755,855),Array(562,695),Array(-541,-357),Array(443,503),Array(134,640),Array(51,520),Array(627,731),Array(-121,45),Array(-941,-641),Array(610,837),Array(-775,-486),Array(306,547),Array(-531,326),Array(282,747),Array(-514,-214),Array(487,532),Array(372,987),Array(-413,-342),Array(739,798),Array(-745,399),Array(-972,739),Array(673,894),Array(931,983),Array(-713,-306),Array(-672,-182),Array(-381,922),Array(738,988),Array(565,618),Array(216,790),Array(879,922),Array(-221,151),Array(315,546),Array(-116,884),Array(554,952),Array(143,442),Array(76,134),Array(340,694),Array(-544,-223),Array(320,880),Array(-414,726),Array(853,922),Array(-885,-17),Array(-974,-68),Array(-795,-365),Array(46,810),Array(-272,419),Array(-875,921),Array(364,521),Array(550,661),Array(-240,559),Array(-825,-107),Array(747,992),Array(17,284),Array(803,918),Array(-650,664),Array(-379,736),Array(969,990),Array(-861,132),Array(70,926),Array(402,937),Array(727,772),Array(-908,-50),Array(-641,-602),Array(-513,-245),Array(338,356),Array(-399,722),Array(-56,770),Array(-226,778),Array(129,569),Array(-562,-300),Array(-820,-543),Array(794,926),Array(695,979),Array(-853,-41),Array(618,797),Array(152,478),Array(-739,684),Array(-509,581),Array(969,983),Array(-333,-39),Array(-131,9),Array(708,980),Array(-426,526),Array(411,912),Array(708,889),Array(859,947),Array(-620,128),Array(-937,418),Array(-975,-752),Array(-511,993),Array(-807,-507),Array(-559,-324),Array(-439,293),Array(948,960),Array(343,679),Array(655,897),Array(58,918),Array(-566,-312),Array(381,688),Array(440,684),Array(-363,61),Array(-647,865),Array(833,881),Array(893,924),Array(-421,534),Array(-404,615),Array(197,320),Array(796,867),Array(-122,380),Array(-114,100),Array(403,415),Array(977,997),Array(-318,700),Array(-96,635),Array(354,684),Array(-587,23),Array(-698,-561),Array(-785,403),Array(-960,36),Array(784,826),Array(618,826),Array(-140,831),Array(562,613),Array(-566,-48),Array(155,391))
    println(findLongestChain(a))    
  }
}