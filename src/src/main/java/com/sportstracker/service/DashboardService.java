import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    public String getDashboardData() {
        // Get the username from the authenticated user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        //API / FETCH DATA FOR DASHBOARD
        return "Welcome to the dashboard, " + username + "!";
    }
}
