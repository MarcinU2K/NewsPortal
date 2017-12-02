package com.newsportal.config;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.newsportal.domain.general.Section;
import com.newsportal.domain.general.SubSection;
import com.newsportal.domain.news.News;
import com.newsportal.domain.user.Role;
import com.newsportal.domain.user.User;
import com.newsportal.repository.news.NewsRepository;
import com.newsportal.repository.user.UserRepository;
import com.newsportal.service.news.NewsServiceImpl;

@Configuration
public class InitMongoDBData {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private NewsServiceImpl newsServiceImpl;
	
	@Autowired
	private NewsRepository newsRepository;
	
	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	private void initDatabase() {
		if (newsRepository.count() == 0 || userRepository.count() == 0) {
			createNews(
					Section.NEWS, 
					SubSection.NEWS_WARSZAWA, 
					"W Warszawie powstanie pomnik 'Solidarności",
					"Ma pojawić się na Skarpie Wiślanej, a w jego projekcie zostanie wykorzystany legendarny znak graficzny związku. W Warszawie powstanie pomnik 'Solidarności' – ogłosiły dziś władze miasta. Jego odsłonięcie planowane jest w setną rocznicę odzyskania niepodległości przez Polskę.",
					"Jak tłumaczy stołeczny Ratusz, pomnik ma upamiętniać ruch społeczny 'Solidarność' i jego walkę z komunizmem. Rada Warszawy zgodziła się na budowę monumentu, podejmując w tej sprawie uchwałę już trzy lata temu, 11 września 2014 r. Zostanie on wzniesiony po południowo-zachodniej stronie skrzyżowania ul. Świętokrzyskiej z ul. Kopernika w warszawskim Śródmieściu. - Pomnik będzie nadawał nową symbolikę 'Solidarności'. Za rok, w 100-lecie odzyskania przez Polskę niepodległości, odsłonimy ten monument. Ten czas jest potrzebny nie tylko na projekt i plan inwestycji, ale także na zmiany na skwerze, które podkreślą wyjątkowość tego miejsca – mówiła dziś Renata Kaznowska, wiceprezydent Warszawy. Inicjatorem budowy pomnika jest Fundacja im. Ronalda Reagana, która poniesie także koszty jego powstania. W monumencie zostanie wykorzystany utwór plastyczny w postaci legendarnego znaku 'Solidarność' autorstwa Jerzego Janiszewskiego. - Myślę, że wczorajsza wypowiedź biskupa Tadeusza Pieronka o 'dramacie Solidarności' najlepiej wyjaśnia potrzebę budowy pomnika w trudnym momencie historycznym, kiedy władza zaprzecza ideę 'Solidarności' i stara się zdeprecjonować jej prawdziwych bohaterów – podkreślała z kolei Ewa Malinowska–Grupińska, przewodnicząca Rady Warszawy. Wspomniany biskup Pieronek stwierdził m.in., że 'najsłabszym argumentem idei jest to, kiedy buduje ona mury. Te mury też przeżyliśmy. Widzę, że dzisiaj się znowu budują'. Stwierdził też, że Lech Wałęsa, który na ustach całego świata jest bohaterem, w Polsce jest niszczony, bo komuś przychodzi do głowy, że można stanąć na piedestale, niszcząc tego człowieka. Jak ocenił, to jest dramat 'Solidarności'. Do czasu budowy pomnika przechodniów będzie o tym informować tablica, umieszczona w docelowym miejscu obiektu. Znalazła się na niej replika zdjęcia 'Strajk w Stoczni Gdańskiej w sierpniu 1988 r.', autorstwa Tomasza Czesława Gutry, z którym została podpisana umowa licencyjna na korzystanie z fotografii oraz tekst: 'W 2018 roku, w tym miejscu, w setną rocznicę odzyskania niepodległości przez Polskę, zostanie odsłonięty pomnik upamiętniający ruch społeczny 'Solidarność' w walce z komunizmem'. Są tam też dwa cytaty: 'Było to przełomowe wydarzenie w historii naszego narodu, ale także w dziejach Europy – 'Solidarność' otworzyła bramy do wolności - Jan Paweł II, papież' oraz 'Żadna broń w światowych arsenałach nie jest tak groźna, jak wola i moralna odwaga wolnych mężczyzn i kobiet – Ronald Reagan, prezydent USA.",
					"https://ocdn.eu/pulscms-transforms/1/qTqktkqTURBXy80MGM3NTgxNmY0ZjdhYzQ1MjEwMzY2MDU2ZmVjYTc1My5qcGVnkpUDABzNAyDNAcKTBc0DFM0BvA"
					);
			createNews(
					Section.SPORT, 
					SubSection.MOTO_NEWS,
					"Charles Leclerc i Marcus Ericsson w składzie Saubera w sezonie 2018",
					"Pochodzący z Monako 20-letni Charles Leclerc oraz 27-letni Szwed Marcus Ericcson będą jeździli w szwajcarskim teamie Sauber w sezonie 2018 Formuły 1. Informację przekazał szef Ferrari Sergio Marchionne na konferencji prasowej we włoskim Arese.",
					"Ericcson pozostaje w zespole, mimo że w 2017 roku nie zdobył ani jednego punktu w wyścigach F1. Niemiec Pascal Wehrlein zdobył ich pięć, ale opuszcza team, którego sponsorem tytularnym została marka Alfa Romeo. Jego miejsce zajmie Leclerc. Decyzje w Sauberze oznaczają, że jedyne wolne miejsce w Formule 1 na kolejny ma sezon ma ekipa Williamsa. O miejsce w brytyjskim teamie starają się m.in. Robert Kubica i Rosjanin Siergiej Sirotkin; uczestniczyli w niedawnych testach w Abu Zabi. Dyrektor techniczny Williamsa Paddy Lowe chwalił Kubicę, ale zastrzegł, że wybór drugiego kierowcy do zespołu nie musi ograniczać się do obecnych tam osób.",
					"https://ocdn.eu/pulscms-transforms/1/24RktkqTURBXy85ZmIyM2MzNTNhYjQ1ZTU5YzBlNjBmMjQ5OTJkZjBhOS5qcGVnkpUDAADNDADNBsCTBc0DFM0BvA"
					);
			createNews(
					Section.BUSINESS, 
					SubSection.TECH_BUSINESS,
					"Elon Musk wyśle w kosmos… Teslę",
					"Elon Musk podał nowe informacje dotyczące wystrzelenia rakiety Falcon Heavy, która ma polecieć w kierunku Marsa. Na jej pokładzie znajdzie się najnowsze auto Tesla Roadster.",
					"Pierwotnie wystrzelenie Falcon Heavy planowane było na listopad tego roku, ale do tego nie doszło. Teraz z informacji, które ujawnił Elon Musk ma Twitterze wynika, że nastąpić to ma w styczniu 2018 roku. Rakieta wystartuje z tego samego miejsca, co prom Apollo 11, znajdującego się na terenie Ośrodka Lotów Kosmicznych na amerykańskim Przylądku Canaveral. Falcon Heavy będzie miał podwójną siłę ciągu w porównaniu do kolejnej największej rakiety - napisał szef SpaceX. Elon Musk nie byłby sobą, gdyby nie wpadł na pomysł oryginalnego ładunku, który znajdzie się na pokładzie rakiety. Będzie to nowe auto Tesla Roadster, zaprezentowane przez firmę w listopadzie. W kosmos poleci samochód tej marki w kolorze wiśniowym. Auto na razie nie jest produkowane. Do sprzedaży ma trafić w 2020 roku, a jego podstawowy model kosztuje 200 tys. dolarów. Miejsce docelowe to orbita Marsa. (Falcon Heavy - przyp.) będzie w kosmosie przez miliard lat, jeśli nie wybuchnie podczas wznoszenia się - napisał Musk. Falcon Heavy jest następcą poprzedniej rakiety stworzonej Space X, czyli Falcona 8. Ma większość moc od poprzednika. Elon Musk ma plan kolonizacji Marsa przez milion osób. Jego najnowsze założenia zaprezentował pod koniec września br.",
					"https://ocdn.eu/pulscms-transforms/1/ZYTk9kqTURBXy9hYzM4ZWU5ZmJlN2ZlNzQ3N2JmYTYyODgxZTMwYjg5My5qcGVnkpUDAMy5zQXazQNKlQLNAeAAwsOBoTEC"
					);
			
			createUser("admin", "password", "ADMIN");
			createUser("user", "password", "USER");
			
		} else {
			log.error("Database not null. Data init not performed");
		}
	}

	private void createNews(Section section, SubSection subSection, String mainTitle, String shortDesc, String newsContent, String imageUri) {
		News news = new News();
		news.setSection(section);
		news.setSubSection(subSection);
		news.setMainTitle(mainTitle);
		news.setShortDesc(shortDesc);
		news.setNewsContent(newsContent);
		news.setImage(imageUri);
		newsServiceImpl.addNews(news);
		
		log.info("DB updated with news: " + news.getMainTitle());
	}

	private void createUser(String username, String password, String role) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setRoles(Arrays.asList(new Role(role.toUpperCase())));
		userRepository.save(user);
		
		log.info("New user " + user.getUsername() + " added!");
	}
}