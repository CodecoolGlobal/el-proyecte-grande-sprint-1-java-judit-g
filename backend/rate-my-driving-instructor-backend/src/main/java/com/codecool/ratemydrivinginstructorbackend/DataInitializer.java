package com.codecool.ratemydrivinginstructorbackend;

import com.codecool.ratemydrivinginstructorbackend.repository.instructor.Instructor;
import com.codecool.ratemydrivinginstructorbackend.repository.instructor.InstructorRepository;
import com.codecool.ratemydrivinginstructorbackend.repository.instructor.LicenseType;
import com.codecool.ratemydrivinginstructorbackend.repository.review.Review;
import com.codecool.ratemydrivinginstructorbackend.repository.appuser.AppUser;
import com.codecool.ratemydrivinginstructorbackend.repository.review.ReviewRepository;
import com.codecool.ratemydrivinginstructorbackend.repository.appuser.ReviewerRepository;
import com.codecool.ratemydrivinginstructorbackend.repository.appuser.Role;
import com.codecool.ratemydrivinginstructorbackend.repository.school.School;
import com.codecool.ratemydrivinginstructorbackend.repository.school.SchoolRepository;
import com.codecool.ratemydrivinginstructorbackend.repository.school.SchoolAddress;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DataInitializer {

    private final ReviewRepository reviewRepository;
    private final SchoolRepository schoolRepository;
    private final ReviewerRepository reviewerRepository;
    private final InstructorRepository instructorRepository;
    private final PasswordEncoder passwordEncoder;
    private Random random = new Random();

    @Autowired
    public DataInitializer(ReviewRepository reviewRepository,
                           SchoolRepository schoolRepository,
                           ReviewerRepository reviewerRepository,
                           InstructorRepository instructorRepository,
                           PasswordEncoder passwordEncoder) {
        this.reviewRepository = reviewRepository;
        this.schoolRepository = schoolRepository;
        this.reviewerRepository = reviewerRepository;
        this.instructorRepository = instructorRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    @PostConstruct
    public void initializeData() {
        AppUser appUser1 = createInitReviewer("xxx", "xxx");
        AppUser appUser2 = createInitReviewer("Éva", "Nagy");
        AppUser appUser3 = createInitReviewer("Péter", "Szabó");
        AppUser appUser4 = createInitReviewer("Kata", "Tóth");
        AppUser appUser5 = createInitReviewer("László", "Varga");
        AppUser appUser6 = createInitReviewer("Mária", "Horváth");
        AppUser appUser7 = createInitReviewer("Béla", "Kiss");
        AppUser appUser8 = createInitReviewer("Zoltán", "Balogh");
        AppUser appUser9 = createInitReviewer("Anna", "Farkas");
        AppUser appUser10 = createInitReviewer("Tamás", "Molnár");

        List<AppUser> appUsers = List.of(
                appUser1, appUser2, appUser3, appUser4, appUser5,
                appUser6, appUser7, appUser8, appUser9, appUser10
        );

        reviewerRepository.saveAll(appUsers);

        Review review1 = createInitReview("Nagyon türelmes és segítőkész.", 5);
        Review review2 = createInitReview("Túl lassú és figyelmetlen volt.", 2);
        Review review3 = createInitReview("Elégedett voltam az órákkal.", 4);
        Review review4 = createInitReview("Többet vártam, de nem volt rossz.", 3);
        Review review5 = createInitReview("Udvarias és profi hozzáállás.", 5);
        Review review6 = createInitReview("Túl szigorú, de korrekt volt.", 3);
        Review review7 = createInitReview("Nem magyarázott el mindent világosan.", 1);
        Review review8 = createInitReview("Kedves és segítőkész, nagyon ajánlom.", 5);
        Review review9 = createInitReview("Csak az alapokat tanította.", 2);
        Review review10 = createInitReview("Nagyszerű oktatás, köszönöm!", 5);
        Review review11 = createInitReview("Figyelmes és támogató volt.", 4);
        Review review12 = createInitReview("Több türelmet vártam volna.", 2);
        Review review13 = createInitReview("Nagyon jól magyarázott.", 5);
        Review review14 = createInitReview("Nem volt eléggé felkészült.", 1);
        Review review15 = createInitReview("Profi és barátságos.", 5);
        Review review16 = createInitReview("Korrekt volt, de lehetett volna jobb.", 3);
        Review review17 = createInitReview("Nem adott megfelelő visszajelzést.", 2);
        Review review18 = createInitReview("Kitűnő tanár, sokat segített.", 5);
        Review review19 = createInitReview("Nem figyelt rám eléggé.", 1);
        Review review20 = createInitReview("Rugalmas és türelmes.", 4);
        Review review21 = createInitReview("Kicsit feszültek voltak az órák.", 2);
        Review review22 = createInitReview("Nagyon jó élmény volt.", 5);
        Review review23 = createInitReview("Jobb magyarázatot vártam volna.", 2);
        Review review24 = createInitReview("Nagyon kedves és segítőkész.", 5);
        Review review25 = createInitReview("Több figyelmet fordíthatott volna rám.", 3);
        Review review26 = createInitReview("Nagyon türelmes és érthető.", 5);
        Review review27 = createInitReview("Sok hibát követett el.", 1);
        Review review28 = createInitReview("Szakszerű és barátságos.", 4);
        Review review29 = createInitReview("Túl szigorú volt.", 2);
        Review review30 = createInitReview("Örömmel tanultam tőle.", 5);
        Review review31 = createInitReview("Túl gyors tempót diktált.", 3);
        Review review32 = createInitReview("Nagyon profi és segítőkész.", 5);
        Review review33 = createInitReview("Túl rövidek voltak az órák.", 2);
        Review review34 = createInitReview("Nagyon sokat tanultam tőle.", 5);
        Review review35 = createInitReview("Nem figyelt rám eléggé.", 2);
        Review review36 = createInitReview("Nagyon rugalmas és türelmes volt.", 4);
        Review review37 = createInitReview("Nem kaptam megfelelő segítséget.", 1);
        Review review38 = createInitReview("Kitűnő tanár, ajánlom.", 5);
        Review review39 = createInitReview("Sokkal többet vártam.", 3);
        Review review40 = createInitReview("Nagyon pozitív élmény volt.", 5);
        Review review41 = createInitReview("Nagyon elégedett voltam az oktatómmal.", 5);
        Review review42 = createInitReview("Az óra hasznos volt, de kicsit gyorsan ment.", 4);
        Review review43 = createInitReview("Az oktató nagyon kedves volt.", 5);
        Review review44 = createInitReview("Nem figyelt rám, ezért nem volt túl jó élmény.", 2);
        Review review45 = createInitReview("Minden rendben volt, szívesen ajánlom.", 4);
        Review review46 = createInitReview("A tanítási módszere nagyon hatékony.", 5);
        Review review47 = createInitReview("Kicsit drága, de a tudás megéri.", 4);
        Review review48 = createInitReview("Túl sok elmélet volt, kevesebb gyakorlat kellett volna.", 3);
        Review review49 = createInitReview("A környezet nagyon barátságos volt.", 5);
        Review review50 = createInitReview("Sok hasznos tippet kaptam.", 4);
        Review review51 = createInitReview("Az oktatója profi, de nem volt elég türelmes.", 3);
        Review review52 = createInitReview("Összességében jó tapasztalat volt.", 4);
        Review review53 = createInitReview("Az órák mindig időben kezdődtek.", 5);
        Review review54 = createInitReview("Jó tanácsokat kaptam a vizsgához.", 5);
        Review review55 = createInitReview("Néhány dolog nehezen ment, de az oktató segített.", 4);
        Review review56 = createInitReview("A tanulás szórakoztató volt.", 5);
        Review review57 = createInitReview("A csoportdinamika is segített az órákon.", 4);
        Review review58 = createInitReview("Több gyakorlatra lett volna szükség.", 3);
        Review review59 = createInitReview("Az óra után magabiztosabbnak érzem magam.", 5);
        Review review60 = createInitReview("Az ár-érték arány megfelelő volt.", 4);
        Review review61 = createInitReview("Nagyon hasznos volt a gyakorlás.", 5);
        Review review62 = createInitReview("Az oktató jól magyarázott, de kicsit türelmetlen volt.", 3);
        Review review63 = createInitReview("Kiváló tanulási élmény!", 5);
        Review review64 = createInitReview("Az órák során sokat fejlődtem.", 4);
        Review review65 = createInitReview("Kicsit drága, de megéri az árát.", 4);
        Review review66 = createInitReview("Az órák érdekesek voltak, de a tempó túl gyors.", 3);
        Review review67 = createInitReview("Sok hasznos információt kaptam.", 5);
        Review review68 = createInitReview("Az oktató nagyon kedves és segítőkész volt.", 5);
        Review review69 = createInitReview("A gyakorlati órák különösen hasznosak voltak.", 5);
        Review review70 = createInitReview("Néhány óra unalmas volt, de összességében jó volt.", 4);
        Review review71 = createInitReview("Az oktatás színvonala nagyon magas.", 5);
        Review review72 = createInitReview("Több gyakorlati órát szerettem volna.", 4);
        Review review73 = createInitReview("Kiváló tanítási módszerek, nagyon ajánlom!", 5);
        Review review74 = createInitReview("Az órák jól szervezettek voltak.", 4);
        Review review75 = createInitReview("Kicsit nehezen ment, de a végén sikerült.", 3);
        Review review76 = createInitReview("A vizsgára való felkészítés kiváló volt.", 5);
        Review review77 = createInitReview("Sokat tanultam az elméleti órákból is.", 4);
        Review review78 = createInitReview("Az órákon mindig jó hangulat volt.", 5);
        Review review79 = createInitReview("Néhány dolog nehezen ment, de az oktató segített.", 4);
        Review review80 = createInitReview("Összességében nagyon elégedett vagyok.", 5);
        Review review81 = createInitReview("Az oktatás során nagyon sokat tanultam.", 5);
        Review review82 = createInitReview("Kiváló tanár, minden kérdésemre válaszolt.", 5);
        Review review83 = createInitReview("Az órák szórakoztatóak voltak, de néha zavaró.", 3);
        Review review84 = createInitReview("A gyakorlati órák nagyon segítőkészek voltak.", 4);
        Review review85 = createInitReview("Kicsit több elmélet is jól jött volna.", 3);
        Review review86 = createInitReview("Örömmel jártam az órákra, mindig jókedvű voltam.", 5);
        Review review87 = createInitReview("Az óra elején mindig jól felkészítettek.", 4);
        Review review88 = createInitReview("A tanulási folyamat izgalmas volt.", 5);
        Review review89 = createInitReview("Néhány óra nagyon intenzív volt.", 4);
        Review review90 = createInitReview("Az oktató türelmes volt és sokat segített.", 5);
        Review review91 = createInitReview("Kicsit lassú volt a tempó, de összességében jó.", 3);
        Review review92 = createInitReview("Az órák között jól éreztem magam, jó csapatban voltam.", 4);
        Review review93 = createInitReview("A tanulás szórakoztató, de néha kicsit fárasztó.", 4);
        Review review94 = createInitReview("Nagyon jól éreztem magam, mindenki segítőkész volt.", 5);
        Review review95 = createInitReview("A vizsga felkészítő órák nagyon hasznosak voltak.", 5);
        Review review96 = createInitReview("Összességében jó élmény volt, de voltak nehézségek.", 4);
        Review review97 = createInitReview("Sok hasznos tippet kaptam az oktatótól.", 5);
        Review review98 = createInitReview("A tanfolyam jó ütemben haladt, élveztem.", 4);
        Review review99 = createInitReview("Kicsit stresszes volt, de a végeredmény megérte.", 4);
        Review review100 = createInitReview("Nagyon örülök, hogy ezt a tanfolyamot választottam.", 5);
        Review review101 = createInitReview("Az órák mindig jól strukturáltak voltak.", 5);
        Review review102 = createInitReview("Kiváló tanár, minden részletre figyelt.", 5);
        Review review103 = createInitReview("Az elméleti anyag érdekes volt, de sok volt belőle.", 4);
        Review review104 = createInitReview("A gyakorlati órák segítettek a vizsgára való felkészülésben.", 5);
        Review review105 = createInitReview("Néha kicsit unalmas volt, de a tananyag hasznos.", 3);
        Review review106 = createInitReview("A tanfolyam jó alapokat adott.", 4);
        Review review107 = createInitReview("Az oktató segítőkész volt, sokat tanultam tőle.", 5);
        Review review108 = createInitReview("A csoportban jó volt a hangulat.", 4);
        Review review109 = createInitReview("Több gyakorlati órára lett volna szükség.", 3);
        Review review110 = createInitReview("Az ár-érték arány remek volt.", 5);
        Review review111 = createInitReview("Az oktatás során mindenki kedves volt.", 5);
        Review review112 = createInitReview("A tanfolyam során sok hasznos információt kaptam.", 4);
        Review review113 = createInitReview("Kicsit lassú volt a tempó, de érthető volt.", 3);
        Review review114 = createInitReview("Sok motiváló beszélgetést hallottam az órák alatt.", 4);
        Review review115 = createInitReview("A vizsga felkészítése nagyon jól ment.", 5);
        Review review116 = createInitReview("Az oktatás színvonala kiemelkedő volt.", 5);
        Review review117 = createInitReview("Összességében pozitív tapasztalatokat szereztem.", 4);
        Review review118 = createInitReview("A tanfolyam végére sokat fejlődtem.", 5);
        Review review119 = createInitReview("Az órák során voltak nehézségek, de jól haladtam.", 4);
        Review review120 = createInitReview("Nagyon örülök, hogy részt vettem ezen a tanfolyamon.", 5);


        List<Review> reviews = List.of(
                review1, review2, review3, review4, review5, review6, review7, review8, review9, review10,
                review11, review12, review13, review14, review15, review16, review17, review18, review19, review20,
                review21, review22, review23, review24, review25, review26, review27, review28, review29, review30,
                review31, review32, review33, review34, review35, review36, review37, review38, review39, review40,
                review41, review42, review43, review44, review45, review46, review47, review48, review49, review50,
                review51, review52, review53, review54, review55, review56, review57, review58, review59, review60,
                review61, review62, review63, review64, review65, review66, review67, review68, review69, review70,
                review71, review72, review73, review74, review75, review76, review77, review78, review79, review80,
                review81, review82, review83, review84, review85, review86, review87, review88, review89, review90,
                review91, review92, review93, review94, review95, review96, review97, review98, review99, review100,
                review101, review102, review103, review104, review105, review106, review107, review108, review109, review110,
                review111, review112, review113, review114, review115, review116, review117, review118, review119, review120
        );

        for (Review review : reviews) {
            AppUser randomAppUser = appUsers.get(random.nextInt(appUsers.size()));
            review.setAppUser(randomAppUser);
            randomAppUser.getReviews().add(review);
        }

        reviewRepository.saveAll(reviews);

        SchoolAddress address1 = createInitSchoolAddress("Budapest", "Nagymező", "1", 1111);
        SchoolAddress address2 = createInitSchoolAddress("Budapest", "Király", "2", 2222);
        SchoolAddress address3 = createInitSchoolAddress("Budapest", "Váci", "3", 3333);
        SchoolAddress address4 = createInitSchoolAddress("Budapest", "Andrássy", "4", 4444);
        SchoolAddress address5 = createInitSchoolAddress("Budapest", "Bartók Béla", "5", 5555);
        SchoolAddress address6 = createInitSchoolAddress("Budapest", "Üllői", "6", 6666);
        SchoolAddress address7 = createInitSchoolAddress("Budapest", "Rákóczi", "7", 7777);
        SchoolAddress address8 = createInitSchoolAddress("Budapest", "Kossuth", "8", 8888);
        SchoolAddress address9 = createInitSchoolAddress("Budapest", "Petőfi", "9", 9999);
        SchoolAddress address10 = createInitSchoolAddress("Budapest", "Jókai", "10", 1010);

        List<SchoolAddress> addresses = List.of(
                address1, address2, address3, address4, address5,
                address6, address7, address8, address9, address10
        );

        School school1 = createInitSchool("Elite Driving School", "+36111111");
        School school2 = createInitSchool("SafeDrive Academy", "+36222222");
        School school3 = createInitSchool("Urban Driving Academy", "+36333333");
        School school4 = createInitSchool("SpeedMaster Driving School", "+36444444");
        School school5 = createInitSchool("Precision Driving School", "+36555555");
        School school6 = createInitSchool("FastTrack Driving School", "+36666666");
        School school7 = createInitSchool("StreetSmart Academy", "+36777777");
        School school8 = createInitSchool("CityWheels Driving School", "+36888888");
        School school9 = createInitSchool("ProDrive Institute", "+36999999");
        School school10 = createInitSchool("Highway Master Driving School", "+36101010");

        List<School> schools = List.of(
                school1, school2, school3, school4, school5,
                school6, school7, school8, school9, school10
        );

        for (int i = 0; i < schools.size(); i++) {
            schools.get(i).setSchoolAddress(addresses.get(i));
        }

        schoolRepository.saveAll(schools);

        Instructor instructor1 = createInitInstructor("Péter", "Nagy", new HashSet<>(Set.of(LicenseType.B, LicenseType.A)));
        Instructor instructor2 = createInitInstructor("Zoltán", "Szabó", new HashSet<>(Set.of(LicenseType.B, LicenseType.A2)));
        Instructor instructor3 = createInitInstructor("Erika", "Kovács", new HashSet<>(Set.of(LicenseType.A1, LicenseType.B)));
        Instructor instructor4 = createInitInstructor("László", "Tóth", new HashSet<>(Set.of(LicenseType.A, LicenseType.B)));
        Instructor instructor5 = createInitInstructor("Miklós", "Varga", new HashSet<>(Set.of(LicenseType.B)));
        Instructor instructor6 = createInitInstructor("Mária", "Horváth", new HashSet<>(Set.of(LicenseType.A, LicenseType.B)));
        Instructor instructor7 = createInitInstructor("Tamás", "Molnár", new HashSet<>(Set.of(LicenseType.B)));
        Instructor instructor8 = createInitInstructor("Anna", "Kiss", new HashSet<>(Set.of(LicenseType.B, LicenseType.A1)));
        Instructor instructor9 = createInitInstructor("Gábor", "Farkas", new HashSet<>(Set.of(LicenseType.B)));
        Instructor instructor10 = createInitInstructor("Lívia", "Balogh", new HashSet<>(Set.of(LicenseType.A, LicenseType.B)));

        Instructor instructor11 = createInitInstructor("Katalin", "Boros", new HashSet<>(Set.of(LicenseType.B)));
        Instructor instructor12 = createInitInstructor("Ádám", "Pintér", new HashSet<>(Set.of(LicenseType.B, LicenseType.A)));
        Instructor instructor13 = createInitInstructor("András", "Székely", new HashSet<>(Set.of(LicenseType.B)));
        Instructor instructor14 = createInitInstructor("Dóra", "Kovács", new HashSet<>(Set.of(LicenseType.B, LicenseType.A1)));
        Instructor instructor15 = createInitInstructor("József", "Szalai", new HashSet<>(Set.of(LicenseType.A2, LicenseType.B)));
        Instructor instructor16 = createInitInstructor("Csaba", "Pataki", new HashSet<>(Set.of(LicenseType.B, LicenseType.A)));
        Instructor instructor17 = createInitInstructor("Zsuzsanna", "Németh", new HashSet<>(Set.of(LicenseType.B)));
        Instructor instructor18 = createInitInstructor("Bálint", "Kis", new HashSet<>(Set.of(LicenseType.B, LicenseType.A)));
        Instructor instructor19 = createInitInstructor("Lilla", "Fülöp", new HashSet<>(Set.of(LicenseType.A1, LicenseType.B)));
        Instructor instructor20 = createInitInstructor("Dániel", "Gál", new HashSet<>(Set.of(LicenseType.B, LicenseType.A2)));

        Instructor instructor21 = createInitInstructor("Gergő", "Tóth", new HashSet<>(Set.of(LicenseType.B, LicenseType.A)));
        Instructor instructor22 = createInitInstructor("Beatrix", "Károlyi", new HashSet<>(Set.of(LicenseType.B)));
        Instructor instructor23 = createInitInstructor("Ferenc", "Sándor", new HashSet<>(Set.of(LicenseType.B, LicenseType.A1)));
        Instructor instructor24 = createInitInstructor("Judit", "Somogyi", new HashSet<>(Set.of(LicenseType.A2, LicenseType.B)));
        Instructor instructor25 = createInitInstructor("Sándor", "Takács", new HashSet<>(Set.of(LicenseType.B, LicenseType.A)));
        Instructor instructor26 = createInitInstructor("Ilona", "Varga", new HashSet<>(Set.of(LicenseType.B, LicenseType.A)));
        Instructor instructor27 = createInitInstructor("László", "Barta", new HashSet<>(Set.of(LicenseType.A1, LicenseType.B)));
        Instructor instructor28 = createInitInstructor("Zsolt", "Papp", new HashSet<>(Set.of(LicenseType.A, LicenseType.B)));
        Instructor instructor29 = createInitInstructor("Viktor", "Juhász", new HashSet<>(Set.of(LicenseType.B)));
        Instructor instructor30 = createInitInstructor("Bence", "Fodor", new HashSet<>(Set.of(LicenseType.B, LicenseType.A)));

        Instructor instructor31 = createInitInstructor("György", "Kertész", new HashSet<>(Set.of(LicenseType.B, LicenseType.A1)));
        Instructor instructor32 = createInitInstructor("Réka", "Szilágyi", new HashSet<>(Set.of(LicenseType.B, LicenseType.A)));
        Instructor instructor33 = createInitInstructor("Norbert", "Fehér", new HashSet<>(Set.of(LicenseType.A2, LicenseType.B)));
        Instructor instructor34 = createInitInstructor("Eszter", "Nagy", new HashSet<>(Set.of(LicenseType.B, LicenseType.A1)));
        Instructor instructor35 = createInitInstructor("Imre", "Szűcs", new HashSet<>(Set.of(LicenseType.B)));
        Instructor instructor36 = createInitInstructor("Borbála", "Major", new HashSet<>(Set.of(LicenseType.B, LicenseType.A)));
        Instructor instructor37 = createInitInstructor("Szilvia", "Veres", new HashSet<>(Set.of(LicenseType.A, LicenseType.B)));
        Instructor instructor38 = createInitInstructor("Tímea", "Varga", new HashSet<>(Set.of(LicenseType.B, LicenseType.A1)));
        Instructor instructor39 = createInitInstructor("Gábor", "Jenei", new HashSet<>(Set.of(LicenseType.B, LicenseType.A2)));
        Instructor instructor40 = createInitInstructor("Ágnes", "Kiss", new HashSet<>(Set.of(LicenseType.B, LicenseType.A)));

        List<Instructor> instructors = List.of(
                instructor1, instructor2, instructor3, instructor4, instructor5, instructor6, instructor7, instructor8, instructor9, instructor10,
                instructor11, instructor12, instructor13, instructor14, instructor15, instructor16, instructor17, instructor18, instructor19, instructor20,
                instructor21, instructor22, instructor23, instructor24, instructor25, instructor26, instructor27, instructor28, instructor29, instructor30,
                instructor31, instructor32, instructor33, instructor34, instructor35, instructor36, instructor37, instructor38, instructor39, instructor40
        );
        instructorRepository.saveAll(instructors);

        for (Instructor instructor : instructors) {
            instructor.setSchool(schools.get(random.nextInt(schools.size())));
        }

        for (Review review : reviews) {
            review.setInstructor(instructors.get(random.nextInt(instructors.size())));
        }
        reviewRepository.saveAll(reviews);
        instructorRepository.saveAll(instructors);
    }

    private SchoolAddress createInitSchoolAddress(String city, String street, String streetNumber, int zipCode) {
        SchoolAddress schoolAddress = new SchoolAddress();
        schoolAddress.setStreetName(street);
        schoolAddress.setStreetNumber(streetNumber);
        schoolAddress.setCity(city);
        schoolAddress.setPostCode(zipCode);
        return schoolAddress;
    }

    private School createInitSchool(String name, String phoneNumber) {
        School school = new School();
        school.setName(name);
        school.setPhoneNumber(phoneNumber);
        return school;
    }

    private Review createInitReview(String description, int rating) {
        Review review = new Review();
        review.setDescription(description);
        review.setRating(rating);
        return review;
    }

    private Instructor createInitInstructor(String firstName, String lastName, Set<LicenseType> licenses) {
        Instructor instructor = new Instructor();
        instructor.setFirstName(firstName);
        instructor.setLastName(lastName);
        instructor.setLicenseType(licenses);
        instructor.setReviews(new HashSet<>(Set.of()));
        return instructor;
    }

    private AppUser createInitReviewer(String name, String password) {
        AppUser appUser = new AppUser();
        appUser.setUsername(name);
        appUser.setPassword(passwordEncoder.encode(password));
        appUser.setRoles(List.of(Role.ROLE_USER));
        return appUser;
    }
}
