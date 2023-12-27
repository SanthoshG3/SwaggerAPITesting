// 1st

package api.endpoint;
/* swagger URL = https://petstore.swagger.io
create User[Post] - https://petstore.swagger.io/v2/user/createWithArray
Get User   [Get] - https://petstore.swagger.io/v2/user/{username}
Update User [Put] = https://petstore.swagger.io/v2/user/{username}
Delete User [Delete] = /https://petstore.swagger.io/v2/user/{username} */


public class Routes {
	
// User Model
		public static String base_url = "https://petstore.swagger.io/v2";
		
		public static String post_url = base_url+"/user";
		
		public static String get_url = base_url+"/user/{username}";
		
		public static String put_url = base_url+"/user/{username}";
		
		public static String delete_url = base_url+"/user/{username}";
	
}
