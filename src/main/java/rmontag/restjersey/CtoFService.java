package rmontag.restjersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Contact;
import io.swagger.annotations.ExternalDocs;
import io.swagger.annotations.Info;
import io.swagger.annotations.License;
import io.swagger.annotations.SwaggerDefinition;

@Path("/ctofservice")
@Api(value="/ctofservice")
@SwaggerDefinition(
		host = "http://tcap001de.azurewebsites.net",
		consumes = {"application/json" , "application/xml"},
        schemes = {SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS},
		
        info = @Info(
                description = "ctofservice",
                version = "V1.2.3",
                title = "The only API you'll ever need to learn about me",
                termsOfService = "share and care",
                contact = @Contact(name = "Sponge-Bob", email = "sponge-bob@swagger.io", url = "http://swagger.io"),
                license = @License(name = "Apache 2.0", url = "http://www.apache.org")),
                
                
        externalDocs = @ExternalDocs(value = "About me", url = "http://about.me/me")
)
public class CtoFService {

	@GET
	@Produces("application/xml")
	@ApiOperation(value="convert celsius to fahrenheit")
	public String convertCtoF() {
		
		Double fahrenheit;
		Double celsius = 36.8;
		fahrenheit = ((celsius*9) / 5) + 32;
		
//		String result = "@Produces(\"application.xml\") Output: \n\nC to F Converter Output: \n\n" + fahrenheit;
//		return "<ctofservice>" + "<celsius>" + celsius + "</celsius>" + "<ctofoutput>" + result + "</ctofoutput>" + "</ctofservice>";

		return "<ctofservice>" + "<celsius>" + celsius + "</celsius>" + "<fahrenheit>" + fahrenheit + "</fahrenheit>" + "</ctofservice>";

	}
	
	@Path("{c}")
	@GET
	@Produces("application/xml")
	@ApiOperation(value="convert celsius to fahrenheit")
	public String convertCtoFfromInput(@ApiParam(value="celsius", required=true) @PathParam("c") Double c) {

		Double fahrenheit;
		Double celsius = c;
		fahrenheit = ((celsius*9) / 5) + 32;
		
//		String result = "@Produces(\"application.xml\") Output: \n\nC to F Converter Output: \n\n" + fahrenheit;
//		return "<ctofservice>" + "<celsius>" + celsius + "</celsius>" + "<ctofoutput>" + result + "</ctofoutput>" + "</ctofservice>";

		return "<ctofservice>" + "<celsius>" + celsius + "</celsius>" + "<fahrenheit>" + fahrenheit + "</fahrenheit>" + "</ctofservice>";

	}
	
}
