package rmontag.restjersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Contact;
import io.swagger.annotations.ExternalDocs;
import io.swagger.annotations.Info;
import io.swagger.annotations.License;
import io.swagger.annotations.SwaggerDefinition;

@Path("/ftocservice")
@Api(value="/ftocservice")
@SwaggerDefinition(
		//host = "http://tcap001de.azurewebsites.net",
		consumes = {"application/json" , "application/xml"},
        schemes = {SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS},
		
        info = @Info(
                description = "ftocservice",
                version = "V1.2.3",
                title = "The only API you'll ever need to learn about me",
                termsOfService = "share and care",
                contact = @Contact(name = "Sponge-Bob", email = "sponge-bob@swagger.io", url = "http://swagger.io"),
                license = @License(name = "Apache 2.0", url = "http://www.apache.org")),
                
                
        externalDocs = @ExternalDocs(value = "About me", url = "http://about.me/me")
)
public class FtoCService {
	
	@GET
	@Produces("application/json")
	@ApiOperation(value="convert fahrenheit to celsius")
	public Response convertFtoC() throws JSONException {
		
		JSONObject jsonObject = new JSONObject();
		Double fahrenheit = 98.24;
		Double celsius;
		celsius = (fahrenheit -32)*5/9;
		jsonObject.put("fahrenheit", fahrenheit);
		jsonObject.put("celsius", celsius);
		
//		String result = "@Produces(\"application/json\") Output: \n\nF to C Converter Output: \n\n" + jsonObject;
//		return Response.status(200).entity(result).build();

		return Response.status(200).entity("" + jsonObject).build();
	}

	@Path("{f}")
	@GET
	@Produces("application/json")
	@ApiOperation(value="convert fahrenheit to celsius")
	public Response convertFtoCfromInput(@ApiParam(value="fahrenheit", required=true) @PathParam("f") float fahrenheit) throws JSONException {
		
		JSONObject jsonObject = new JSONObject();
		float celsius;
		celsius = (fahrenheit -32)*5/9;
		jsonObject.put("fahrenheit", fahrenheit);
		jsonObject.put("celsius", celsius);
		
//		String result = "@Produces(\"application/json\") Output: \n\nF to C Converter Output: \n\n" + jsonObject;
//		return Response.status(200).entity(result).build();

		return Response.status(200).entity("" + jsonObject).build();
	}

}
