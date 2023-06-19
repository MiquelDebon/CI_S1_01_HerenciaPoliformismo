public class New {
    private String title;
    private String text;
    private int puntuation;
    private int price;


    public New(String title){
        this.title = title;
    }


    public String getTitle() {
        return this.title;
    }
    public String getText() {
        return this.text;
    }
    public int getPuntuation() {
        return this.puntuation;
    }
    public int getPrice() {
        return this.price;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setText(String text) {
        this.text = text;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public void increasePrice(int rise){
        this.price = price + rise;
    }
    public void setPunctuation(int punctuation){
        this.puntuation = punctuation;
    }
    public void increasePunctuation(int puntuation){
        this.puntuation += puntuation;
    }

    @Override
    public String toString() {
        return "New{" +
                "title='" + title + '\'' +
                '}';
    }
}

class FootballNew extends  New implements PriceNew, PuntuationNew{
    private String competition;
    private String club;
    private String player;


    public FootballNew(String title, String competition, String club, String player) {
        super(title);
        super.setPrice(300);
        super.setPunctuation(5);
        this.competition = competition;
        this.club = club;
        this.player = player;
    }


    public String getCompetition() {
        return this.competition;
    }
    public String getClub() {
        return this.club;
    }
    public String getPlayer() {
        return this.player;
    }
    public void setCompetition(String competition) {
        this.competition = competition;
    }
    public void setClub(String club) {
        this.club = club;
    }
    public void setPlayer(String player) {
        this.player = player;
    }
    @Override
    public int getPrice(){
        calculatePriceNew();
        return super.getPrice();
    }
    @Override
    public int getPuntuation() {
        calculatePuntation();
        return super.getPuntuation();
    }
    @Override
    public String toString(){
        return String.format("Una noticia que parla d'un gol de '%s' del '%s' da la '%s' , té un preu de %d €",
                this.player, this.club, this.competition, this.getPrice());
    }
    @Override
    public void calculatePriceNew() {
        if(this.competition.equalsIgnoreCase("Lliga de Campions")) {
            super.increasePrice(100);
        }
        if (this.club.equalsIgnoreCase("Barça") || this.club.equalsIgnoreCase("Madrid")) {
            super.increasePrice(100);
        }
        if (this.player.equalsIgnoreCase("Ferran Torres") || this.player.equalsIgnoreCase("Benzema")) {
            super.increasePrice(50);
        }
    }
    @Override
    public void calculatePuntation() {
        if(this.competition.equalsIgnoreCase("LLiga de Campions")){
            super.increasePunctuation(3);
        }else if(this.competition.equalsIgnoreCase("LLiga")){
            super.increasePunctuation(2);
        }

        if(this.club.equalsIgnoreCase("Barça")||this.club.equalsIgnoreCase("Madrid")){
            super.increasePunctuation(1);
        }

        if(this.player.equalsIgnoreCase("Ferran Torres")||this.player.equalsIgnoreCase("Benzema")){
            super.increasePunctuation(1);
        }
    }
}

class BasquetNew extends New implements PriceNew, PuntuationNew{
    private String competition;
    private String club;


    public BasquetNew(String title, String competition, String club) {
        super(title);
        super.setPrice(250);
        super.setPunctuation(4);
        this.competition = competition;
        this.club = club;
    }


    public String getCompetition() {
        return this.competition;
    }
    public void setCompetition(String competition) {
        this.competition = competition;
    }
    public String getClub() {
        return this.club;
    }
    public void setClub(String club) {
        this.club = club;
    }

    //TODO DUDA si está bien?!
    @Override
    public int getPrice(){
        calculatePriceNew();
        return super.getPrice();
    }
    @Override
    public int getPuntuation() {
        calculatePuntation();
        return super.getPuntuation();
    }
    @Override
    public void calculatePriceNew() {
        if(this.competition.equalsIgnoreCase("Eurolliga")){
            super.increasePrice(75);
        }
        if(this.club.equalsIgnoreCase("Barça")||this.club.equalsIgnoreCase("Madrid")){
            super.increasePrice(75);
        }
    }
    @Override
    public String toString(){
        return String.format("Una noticia que parla de Basquet del club '%s' da la competició '%s', té un preu de %d €",
                 this.club, this.competition, this.getPrice());
    }
    @Override
    public void calculatePuntation() {
        if(this.competition.equalsIgnoreCase("Eurolliga")){
            super.increasePunctuation(3);
        }else if(this.competition.equalsIgnoreCase("ACB")){
            super.increasePunctuation(2);
        }

        if(this.club.equalsIgnoreCase("Barça")||this.club.equalsIgnoreCase("Madrid")){
            super.increasePunctuation(1);
        }
    }
}

class tenisNew extends New implements PriceNew, PuntuationNew{
    private String competition;
    private String player;


    public tenisNew(String title, String competicio, String player) {
        super(title);
        super.setPrice(150);
        super.setPunctuation(4);
        this.competition = competicio;
        this.player = player;
    }

    public String getCompetition() {
        return this.competition;
    }
    public void setCompetition(String competition) {
        this.competition = competition;
    }
    public String getPlayer() {
        return this.player;
    }
    public void setPlayer(String player) {
        this.player = player;
    }
    @Override
    public int getPrice(){
        calculatePriceNew();
        return super.getPrice();
    }

    @Override
    public int getPuntuation() {
        calculatePuntation();
        return super.getPuntuation();
    }
    @Override
    public void calculatePriceNew() {
        if(this.player.equalsIgnoreCase("Federer")||this.player.equalsIgnoreCase("Nadal")||this.player.equalsIgnoreCase("Djokovic")){
            super.increasePrice(100);
        }
    }
    @Override
    public void calculatePuntation() {
        if(this.player.equalsIgnoreCase("Federer")||this.player.equalsIgnoreCase("Nadal")||this.player.equalsIgnoreCase("Djokovic")){
            super.increasePunctuation(3);
        }
    }
    @Override
    public String toString(){
        return String.format("Una noticia que parla de Tenis del jugador '%s' de la competició '%s', té un preu de %d €",
                this.player ,this.competition, this.getPrice());
    }
}

class F1New extends New implements PriceNew, PuntuationNew{
    private String team;


    public F1New(String title, String team) {
        super(title);
        super.setPrice(100);
        super.setPunctuation(4);
        this.team = team;
    }


    public String getTeam() {
        return team;
    }
    public void setTeam(String team) {
        this.team = team;
    }

    @Override
    public int getPrice() {
        calculatePriceNew();
        return super.getPrice();
    }

    @Override
    public int getPuntuation() {
        calculatePuntation();
        return super.getPuntuation();
    }

    @Override
    public void calculatePriceNew() {
        if(this.team.equalsIgnoreCase("Ferrari")||this.team.equalsIgnoreCase("Mercedes")){
            super.increasePrice(50);
        }
    }
    @Override
    public String toString(){
        return String.format("Una noticia que parla de F1 del team '%s', té un preu de %d €",
                this.team , this.getPrice());
    }
    @Override
    public void calculatePuntation() {
        if(this.team.equalsIgnoreCase("Fearria")||this.team.equalsIgnoreCase("Yamaha")){
            super.increasePunctuation(3);
        }
    }
}

class bikesNew extends New implements PriceNew, PuntuationNew{
    private String team;


    public bikesNew(String title, String team) {
        super(title);
        super.setPrice(100);
        super.setPunctuation(3);
        this.team = team;
    }


    public String getTeam() {
        return team;
    }
    public void setTeam(String team) {
        this.team = team;
    }
    @Override
    public int getPrice(){
        calculatePriceNew();
        return super.getPrice();
    }

    @Override
    public int getPuntuation() {
        calculatePuntation();
        return super.getPuntuation();
    }

    @Override
    public void calculatePriceNew() {
        if(this.team.equalsIgnoreCase("Honda")||this.team.equalsIgnoreCase("Yamaha")){
            super.increasePrice(50);
        }
    }
    @Override
    public void calculatePuntation() {
        if(this.team.equalsIgnoreCase("Honda")||this.team.equalsIgnoreCase("Yamaha")){
            super.increasePunctuation(3);
        }
    }

    @Override
    public String toString(){
        return String.format("Una noticia que parla de MotoGP del team '%s', té un preu de %d €",
                this.team , this.getPrice());
    }
}

