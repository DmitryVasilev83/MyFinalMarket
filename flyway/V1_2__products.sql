alter table products
    add description text;

update products
set description = 'Молоко пастеризованное 2,5% изготовлено из свежего сырого коровьего молока высшего сорта.
Содержит сбалансированное количество насыщенных жирных кислот, белка, витаминов, макро- и микроэлементов, необходимых каждому человеку.
Идеально подходит для беременных и кормящих мам, для людей с ослабленным иммунитетом. Большая упаковка удобна для ежедневного потребления продукта всеми членами семьи.
Также молоко подходит для приготовления различных напитков и блюд.
Состав: Нормализованное молоко.'
where id = 1;

update products
set description = 'Хлеб изготовлен традиционным способом из смеси ржаной и пшеничной муки на жидких ржаных заквасках.
Популярный ржано-пшеничный хлеб всегда очень аппетитный, вкусный и ароматный. Восхитительный хлеб идеально подходит для приготовления горячих бутербродов и сытных сэндвичей.
Состав: Мука пшеничная хлебопекарная высший сорт, мука ржаная обдирная, закваска, сахар, соль, масло растительное, дрожжи.
Подробную информацию о товаре смотри на информационном листе. Продукт готов к употреблению.Дата и время изготовления указаны на доп. этикетке.'
where id = 2;

update products
set description = 'Сыр полутвердый, кусок, 50% – это универсальный полутвердый сыр с мягким сливочным вкусом.
Сыр Grünländer производится по технологии естественного созревания из отборных ингредиентов: молока и натуральных заквасок без добавления консервантов.
Он зреет ровно столько, сколько заложено природой. Именно поэтому сыр получается таким вкусным. Естественно созревает ‒ естественно вкусно!
Готовьте с сыром аппетитные закуски, брускетты на хлебе с медом, орехом и прошутто.
Полутвердый сыр прекрасно дополнит горячие блюда, например, говядину с луком, помидорами, чесноком и оливками, а также холодные салаты с курицей.
Отлично подойдет для завтраков: бутерброды, тосты и омлеты с добавлением сыра – насыщенный и быстрый завтрак готов.
Состав: Молоко нормализованное пастеризованное, соль, уплотнитель хлорид кальция, заквасочная культура молочнокислых микроорганизмов(Lactococcus lactis), молокосвертывающий ферментный препарат микробного происхождения, краситель каротины.'
where id = 3;

update products
set description = 'Масло сливочное 82,5% обладает нежным вкусом.
Масло используется для приготовления бутербродов, слоеного и песочного теста, кондитерского крема, добавляется в каши и другие блюда.
Состав: Пастеризованные сливки.'
where id = 4;

update products
set description = 'Бублики изготовлены из пшеничной муки и имеют форму кольца.
Отличаются способом приготовления, при котором сформированное дрожжевое тесто слегка отваривают в кипятке, а затем запекают.
Благодаря такой технологии корочка становится хрустящей, а мякиш эластичным. Бублики сверху посыпаны маком. Подходят для легкого перекуса или подаются к чаю.
Состав: Мука пшеничная хлебопекарная 1-го сорта, вода питьевая, сахар, маргарин (рафинированные дезодорированные растительные масла, вода,эмульгаторы (Е471, Е475),
соль, антиокислители (Е304i, Е306), регулятор кислотности лимонная кислота, ароматизатор, красители:куркумин, Е160b), дрожжи хлебопекарные, мак пищевой, соль.'
where id = 5;

update products
set description = 'Пирожок «Босоногое детство» – нежное хлебобулочное изделие со вкусом ванили и приятным ароматом домашней выпечки.
Пирожок напомнит Вам о беззаботном детстве, когда царила атмосфера расслабленности и спокойствия.
Состав: Мука пшеничная хлебопекарная высшего сорта, сахар, вода, продукты яичные: меланж жидкий,
маргарин (рафинированные дезодорированныерастительные масла, вода, эмульгаторы (моно- и диглицериды жирных кислот, эфиры полиглицерина и жирных кислот),
соль, ароматизатор, краситель – каротины, регулятор кислотности – лимонная кислота), дрожжи хлебопекарные прессованные,
комплексная пищевая добавка(мука пшеничная хлебопекарная высшего сорта, антиокислитель – аскорбиновая кислота, регулятор кислотности – лимонная кислота),
молоко сухое обезжиренное, соль, ароматизатор.'
where id = 6;

update products
set description = 'Это пчелоопыляемый сорт салатного типа.'
where id = 7;

update products
set description = 'Розовые томаты отличаются укрупненным размером, сладким, более насыщенным вкусом и тонкой кожицей.'
where id = 8;

update products
set description = 'Напиток, сильногазированный, натуральный и яркий.
Экстракт чая в составе и много пузырьков понравятся каждому в вашей семье. Пейте охлажденным. Напиток пьют охлажденным, можно использовать в коктейлях.
Состав: Очищенная вода, сахар, регулятор кислотности – лимонная кислота, краситель – сахарный колер IV, натуральный ароматизатор, экстрактчая,
подсластитель – сахаринат натрия, инвертный сахарный сироп, карамельный сироп, антиокислитель – аскорбиновая кислота,консерванты: сорбат калия, бензоат натрия.'
where id = 9;

update products
set description = 'Масло подсолнечное, рафинированное, дезодорированное – это очищенный от всех примесей продукт 1-го сорта. Он содержит витамины Е и F,
полиненасыщенные жирные кислоты Омега-3 и Омега-6 и улучшает функцию сердца. Оно обеспечит сохранность естественных вкусов и ароматов всех приготовленных блюд.
Состав: Масло подсолнечное дезодорированное вымороженное.'
where id = 10;

update products
set description = 'Эскимо - шоколадный трюфель – это шоколадное мороженое с кусочками печенья брауни и шоколадным соусом, покрытое роскошным молочным шоколадом.
Изысканный десерт порадует вас незабываемым сочетанием вкусов. Позвольте себе утонченное удовольствие! МАГНАТ – первое эскимо на российском рынке, которое покрыто настоящим шоколадом,
а не шоколадной глазурью. Для производства используются самые передовые технологии и лучшие мировые практики. Мороженое неоднократно получало награды «Товар года» и «Бренд года».
Состав: Омск: мороженое сливочное шоколадное (цельное молоко, сахар, сироп глюкозы, вода, масло сливочное (B) или молочный жир (F),сыворотка сухая, какао-порошок, молоко сухое, мальтодекстрин,
эмульгатор: моно- и диглицериды жирных кислот, стабилизаторы: гуароваякамедь, камедь рожкового дерева, каррагинан), молочный шоколад (сахар, какао-масло, какао тертое, сухое цельное молоко, молочныйжир,
эквивалент масла какао, сыворотка сухая, эмульгаторы лецитин, Е476, ароматизатор ванильный), шоколадный наполнитель (сахар,вода, какао-порошок, кокосовое масло, молоко сухое обезжиренное, стабилизатор пектин,
натуральный ароматизатор шоколад),шоколадные бисквиты (сахар, мука пшеничная, соленое сливочное масло, какао-порошок, яйца, кукурузная мука, соль пищевая поваренная,разрыхлитель гидро.'
where id = 11;

update products
set description = 'Напиток без сахара сильногазированный – знакомый вкус с новыми крутыми впечатлениями. Это классический аромат колы, яркий, насыщенный, который освежает, утоляет жажду и дарит хорошее настроение.
Попробуйте использовать напиток в коктейлях, дополняйте десерты газировкой или просто пейте охлажденным.
Состав: Очищенная вода, краситель сахарный колер IV, регуляторы кислотности: ортофосфорная кислота, цитрат натрия 3-замещенный,подсластители (натриевая соль цикламовой кислоты, ацесульфам калия, аспартам),
натуральный ароматизатор, кофеин (менее 150 мг/л).Содержит источник фенилаланина.'
where id = 12;

update products
set description = 'Яркий, оригинальный, позитивный, современный, напиток ДОБРЫЙ Лимон, лайм сильногазированный – прохладительный лимонад с ярким лимонным ароматом. Яркий цитрусовый вкус продукта утоляет жажду и
вдохновляет на новые приключения. Попробуйте использовать напиток в коктейлях, дополняйте десерты газировкой или просто пейте охлажденным.
Состав: Очищенная вода, сахар, регуляторы кислотности: лимонная кислота, цитрат натрия 3-замещенный, натуральные ароматизаторы,подсластители: ацесульфам калия, аспартам, консервант – сорбат калия. Содержит источник фенилаланина.'
where id = 13;


update products
set description = 'Моющее средство – густой гель, который эффективно удаляет любые загрязнения даже в холодной воде, отлично смывается. Оно хорошо пенится, придает посуде кристальный блеск,
после ополаскивания не отставляет разводов. Так же подходит для влажной уборки в квартире.
Состав: Вода (более 30%), анионные ПАВ (5% или более, но менее 15%), амфотерные ПАВ (менее 5%), неиногенные ПАВ (манее 5%), консерванты(бензисотхиазолинон, метилизотиазолинон) (менее 5%), парфюмерная композиция (менее 5%).'
where id = 14;

update products
set description = 'Губки для посуды изготовлены из высококачественного поролона и абразива. Мягкий поролоновый слой для деликатного мытья, жесткий абразивный – для сильных загрязнений.
Состав: поролон,абразивный слой'
where id = 15;

update products
set description = 'Туалетное мыло - крем оставляет на коже невероятные ощущения комфорта. Увлажняющие компоненты в составе мыла разгладят и насытят влагой кожу. Входящий в состав крем-ланолин увлажняет, защищает и питает кожу,
повышая ее эластичность, в результате чего кожа становится мягче и выглядит моложе.
Состав: Sodium palmate, aqua, sodium palm kernelate, glycerin, palm kernel acid, sodium chloride, sodium pca, tetrasodium edta, tetrasodiumetidronate, citronellol, geraniol, hexyl cinnamal, linalool, ci 77891, ci 11680, ci 12490.'
where id = 16;

update products
set description = 'Перчатки хозяйственные размер М имеют не скользящую текстуру и специальное усиление на пальцах. Произведены из прочного материала, обладающего высокими износостойкими характеристиками.
Защищают кожу рук от загрязнений, покраснений, сухости, негативного воздействия бытовой химии. Подходят для мытья посуды, уборки помещений, стирки вещей, чистки сантехники.
Состав: ПВХ'
where id = 17;

update products
set description = 'Стиральный порошок предназначен для стирки изделий всех видов тканей (кроме изделий из натурального шелка и шерсти). Уникальная формула порошка делает его максимально эффективным.
Справляется со сложными загрязнениями и пятнами (сажа, оливковое масло, минеральное масло, кровь, молоко, какао, шоколадный крем, каша, трава, чай, красное вино, косметика, крахмал, пудинг, соусы).
Предотвращает посерение ткани и обновляет внешний вид изделий. Защищает волокна ткани. Отстирывает при низких температурах (от 30 градусов). Защищает нагревательные элементы стиральной машины от известковых отложений.
Состав: 5–15%: фосфаты, анионные пав, кислородсодержащий отбеливатель, 5%: фосфонаты, пеногаситель, неионогенные пав, поликарбоксилаты,энзимы, оптические отбеливатели, отдушка.'
where id = 18;
