package com.example.sanjeevyadav.knit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class AboutUsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        recyclerView=findViewById(R.id.about_us_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        toolbar=findViewById(R.id.toolbar_id);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("About Us");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ArrayList<Company> companies=new ArrayList<>();
        ArrayList<Product> product1=new ArrayList<>();
        product1.add(new Product("<p>\n" +
                "KNIT was initially established as the Faculty of Technology in the year 1976 by Kamla Nehru Memorial Trust. It was taken over by the Govt. of Uttar Pradesh in 1979 with a view to developing a full-fledged Engineering Institute in the Eastern UP region better known as the Awadh region. Later, in the year 1983 it was registered as a separate society and renamed as the Kamla Nehru Institute of Technology.\n" +
                "<br><br>The Institute is one of the leading technical Institutions of the region and is responsible for producing top-grade engineers with skill sets comparable with the best in the world. Being fully aware of its social responsibilities and the addressing the issue of application of technology to industry, it also renders the testing and consultancy services to the neighboring industries and various other agencies. The Institute is presently Autonomous College Of Dr. A.P.J. Abdul Kalam Technical University, formerly Uttar Pradesh Technical University, Lucknow.\n" +
                "</p>"));
        Company history=new Company("History",product1);
        companies.add(history);
        ArrayList<Product> product2=new ArrayList<>();
        product2.add(new Product("<p>To create globally competitive, well qualified professionals for contributing to the fulfillment of the needs of the society and to be a resource centre for generation and dissemination of technology for the socio-economic development of the society.  Also, to lay emphasis on industry, institute interaction, to develop education programs and to better the entrepreneurship skills of the students.\n" +
                "<h3 ><font color=\"#FF0000\">Location</h3>\n" +
                "<p>The Institute is situated 5 Km away from the city(Sultanpur) on Allahabad-Faizabad state highway on the bank of river Gomti. It is well connected through road and rail network. The nearest airport is Amousi(Lucknow) and Babatpur(Varanasi) which is about 140 Km far from the Institute.</p>\n"));
        Company vision=new Company("Vision",product2);
        companies.add(vision);
        ArrayList<Product> product3=new ArrayList<>();
        product3.add(new Product("<p>\n" +
                "<h3><font color=\"#ff0000\">Hostels</h3>\n" +
                "<p>\n" +
                "The Institute presently has Ten Boys Hostels to accommodate about 750 male students and Three\n" +
                "Girls’ Hostel to accommodate about 200 Girl students. One new boys’ hostel of 100 seat\n" +
                "capacity is\n" +
                "under the process of construction. A 240 seat\n" +
                "capacity Girls’ Hostel is also under construction and\n" +
                "is expected to commence early next year. Each Hostel has its own mess facility and other\n" +
                "amenities. Hostel and mess rules are given in Annexure II,\n" +
                "II A & II B.\n" +
                "<br/><br/></p>\n" +
                "<h3><font color=\"#ff0000\">Dispensary</h3>\n" +
                "<p>\n" +
                "The Institute maintains a Heath Center to provide primary health care facilities to its students & staff\n" +
                "under a fulltime\n" +
                "Medical Officer (M.O.) and pharmacists. However, cases requiring specialized\n" +
                "treatment are referred to the District Hospital, Sultanpur.\n" +
                "<br/>\n" +
                "<br/></p>\n" +
                "\n" +
                "\n" +
                "\n" +
                "<h3><font color=\"#ff0000\">Bank</h3>\n" +
                "<p>\n" +
                "The Institute have a branch of Punjab National Bank (PNB) and Bank of Baroda(BoB) with ATM facility .<br/><br/>\n" +
                "</p>\n" +
                "<h3><font color=\"#ff0000\">Post Office</h3>\n" +
                "<p>The Institute has an exclusive Post Office which is located at the main gate of the Institute.\n" +
                "<br/><br/></p>\n" +
                "<h3><font color=\"#ff0000\">Canteen</h3>\n" +
                "<p>The Institute has one large cafeteria and a canteen in the hostel premises exclusively to serve the\n" +
                "students. One canteen, located in the academic complex provides services to the staff during\n" +
                "working hours.<br/><br/></p>\n" +
                "\n" +
                "<h3><font color=\"#ff0000\">Guest House</h3>\n" +
                "<p>The Institute has a guest house with good accommodation and dining facilities. The\n" +
                "accommodation for guests is arranged on request on payment at the nominal charges. The booking\n" +
                "is made through the OfficerIn\n" +
                "charge, Guest House.<br/><br/></p>\n" +
                "\n" +
                "<h3><font color=\"#ff0000\">Transport Facility</h3>\n" +
                "<p>The Institute has a 52 seat\n" +
                "deluxe bus for the students for their local journeys and outstation\n" +
                "educational tours. In order to deal with medical emergencies, the Institute also has a wellequipped\n" +
                "Ambulance which is stationed 24 hours in the hostels premises with a driver.<br/><br/></p>\n" +
                "\n" +
                "<h3><font color=\"#ff0000\">Internet Facilities</h3>\n" +
                "<p>The Institute provides 24x7 Internet facility through 1 Gbps (1:1) leased line. This Internet facility is\n" +
                "available in all the Academics Departments, Hostels, Library, various sections of the Institute &\n" +
                "Guest house and also in Faculty and Technical staff Residences.<br/><br/></p>\n" +
                "<h3><font color=\"#ff0000\">Security</h3>\n" +
                "<p>\n" +
                "Security of the Institute is looked after by a Security Agency comprising of a Security Officer and\n" +
                "about 50 security guards. A senior faculty member is the overall in charge of the entire security setup.\n" +
                "The whole Institute campus including academic area, administration building, hostels, and\n" +
                "residential complex is fully covered by the security round the clock.<br/><br/></p></p>"));
        Company facilities=new Company("Campus Facilities",product3);
        companies.add(facilities);

        ArrayList<Product> product4=new ArrayList<>();
        product4.add(new Product("<p>\n" +
                "<h3><font color=\"#ff0000\">EXAMINATION RULES<a name=\"examination\"></a></h3>\n" +
                "Students are advised to make themselves familiar with the syllabus of study and Examination\n" +
                "Rules & Ordinances of the AKTU Lucknow.\n" +
                "The Relevant Rules, Syllabus and Ordinances are\n" +
                "provided at the time of registration and also available at Dr. A.P.J. Abdul Kalam Technical University website.\n" +
                "<br/>\n" +
                "<br/>\n" +
                "\n" +
                "\t\t\n" +
                "<h3><font color=\"#ff0000\">Library Rules<a name=\"library\"></a></h3>\n" +
                "Every bona fide student can obtain the Institute Library membership. The students are issued\n" +
                "borrower’s cards for issue and return of books and journals. The borrowers’ cards are issued to every student on\n" +
                "applying through a prescribed form which is to be recommended by Dean Students Welfare. The norms for the issuance of\n" +
                "books/journal are as follows.<br/><br>\n" +
                "    <p><strong>1. Limit of Books: </strong><br>\n" +
                "  B.Tech. I &amp; II Year -------------------- 5 Books for 30 days<br>\n" +
                "  \n" +
                "  B. Tech. III Year ----------------------- 5 Books for 30 days<br>\n" +
                " \n" +
                "  B.Tech. IV Year ----------------------- 5 Books for 30 days<br>\n" +
                "  \n" +
                "  M.Tech. (part time) &amp; MCA ----- 5 Books for 30 days<br><br>\n" +
                "  \n" +
                "    <strong>2. Issue Hours for Library Books: </strong><br>\n" +
                "  \n" +
                "    Monday to Saturday ------ 11.30 A.M. to 1.00 P.M. &amp; 2.00 P.M. to 4.30. P.M<br><br>\n" +
                " \n" +
                "    <strong>3. Overdue Charges: </strong><br>\n" +
                "  \n" +
                "    <strong>A.</strong> E 0.50 per day per book (On general books)<br>\n" +
                " \n" +
                "    <strong>B. </strong>E 1.00 per day per volume on reserve, reference books and bound Journals.<br><br>\n" +
                " \n" +
                "\n" +
                "    <strong>4. </strong>Unbound Journals are not ordinarily issued to students.<br><br>\n" +
                "  \n" +
                "    <strong>5.</strong> If any reader is found involved in stealing/destroying or damaging any type of reading materials, he may be penalized Rs.1000/or double the cost of reading material whichever is higher along with suspension of Library membership for six months.<br>\n" +
                "\n" +
                "\n" +
                "<h3><font color=\"#ff0000\">BOOK BANK RULES<a name=\"bookbank\"></a></h3>\n" +
                "\n" +
                "Book Bank’s membership form and Borrower’s card may be obtained from the Library. The form is to be\n" +
                "submitted to Library after the recommendation of Dean of Student Welfare with `Rs. 50 as the caution\n" +
                "money which is refundable after the passing /leaving of the Institute. A sum of. `Rs. 3 per book per\n" +
                "semester is charged as rent. Maximum four books are issued at a time under the Book Bank scheme<br/>\n" +
                "<br/>\n" +
                "<h3><font color=\"#ff0000\">SC/ST Book Bank</h3>\n" +
                "Institute Library has SC/ST Book Bank. SC/ST students may be issued four books per Semester after\n" +
                "the producing SC/ST certificate issued by competent authority.<br/><br/>\n" +
                "<h3><font color=\"#ff0000\">Loss of Books</h3>\n" +
                "In case of loss or damage caused to the issued books, the student will be required to submit the same\n" +
                "title or will be charged the current price of the book along with 25% extra charges as fine.<br/>\n" +
                "<br/></p>"));
        Company rules=new Company("Rules",product4);
        companies.add(rules);

        ProductAdapter adapter= new ProductAdapter(companies);
        recyclerView.setAdapter(adapter);



    }
}
