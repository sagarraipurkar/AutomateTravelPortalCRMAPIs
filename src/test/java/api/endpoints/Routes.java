package api.endpoints;

public class Routes {

	public static String base_Url = "http://13.233.79.181:7105";

	// Agency Module
	public static String Post_url = base_Url + "/api/Agency";
	public static String get_url = base_Url + "/api/Agency/{agencyId}";
	public static String update_url = base_Url + "/api/Agency/{agencyId}";

	// Lead Module
	public static String Post_Lead = base_Url + "/api/Leads";
	public static String get_Lead = base_Url + "/api/Leads/{leadId}";
	public static String Put_Lead = base_Url + "/api/Leads/{leadId}";
	public static String Put_Lead_list = base_Url + "/api/Leads/list";

	// Agent Module
	public static String Post_agent = base_Url + "/api/agents";
	public static String get_agent = base_Url + "/api/Agents/{agentId}";
	public static String Put_agent= base_Url + "/api/Agents/{agentId";
	public static String Post_agent_list = base_Url + "/api/Agents/list";
	
	// Branch Module
	public static String Post_branch = base_Url + "/api/Branch";
	public static String get_branch = base_Url + "/api/Branch/{branchId}";
	public static String Put_branch= base_Url + "/api/Branch/{branchId}";
	public static String delete_branch = base_Url + "/api/Branch/{branchId}";
}
