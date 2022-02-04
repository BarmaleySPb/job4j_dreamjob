package dream.store;

import dream.model.Candidate;
import dream.model.Post;
import dream.model.User;

import java.util.Collection;


public interface Store {

    Collection<Post> findAllPosts();
    Collection<Candidate> findAllCandidates();
    void save(Post post);
    void save(Candidate candidate);
    void save(User user);
    Post findPostById(int id);
    Candidate findCandidateById(int id);
    User findUserById(int id);
    void deletePost(int id);
    void deleteCandidate(int id);
    void deleteUser(int id);
}