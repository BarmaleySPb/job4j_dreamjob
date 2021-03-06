package dream.store;

import dream.model.Candidate;
import dream.model.City;
import dream.model.Post;
import dream.model.User;

import java.util.Collection;


public interface Store {

    Collection<Post> findAllPosts();
    Collection<Post> findAllPostsToday();
    Collection<Candidate> findAllCandidates();
    Collection<Candidate> findAllCandidatesToday();
    Collection<City> findAllCities();
    void save(Post post);
    void save(Candidate candidate);
    void save(User user);
    Post findPostById(int id);
    Post findPostByName(String name);
    Candidate findCandidateById(int id);
    Candidate findCandidateByName(String name);
    User findUserById(int id);
    User findUserByEmail(String email);
    void deletePost(int id);
    void deleteCandidate(int id);
    void deleteUser(int id);
}