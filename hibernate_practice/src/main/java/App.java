import java.util.List;

import model.Country;
import service.CountryService;
import service.RegionService;





public class App 
{
    public static void main( String[] args )
    {
        CountryService  countryService = new CountryService();
        RegionService regionService = new RegionService();

         
        // Region region = new Region();
        // region.setRegionName("Asia");  
        // regionService.createRegion(region); 

        
        // Country country = new Country();
        // country.setCountryId("IN");
        // country.setCountryName("India");
        // country.setRegion(region); 
        // countryService.createCountry(country); 
        // System.out.println("Country object created and saved successfully.");

        List<Country> countries = countryService.getAllCountries();
        
        for(Country obj: countries){
            System.out.println("Id:"+obj.getCountryId()+"\nName:"+obj.getCountryName()+"Region:"+obj.getRegion());
        }



    }
}
