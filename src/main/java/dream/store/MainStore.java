package dream.store;

import dream.model.Candidate;
import dream.model.Post;


public class MainStore {
    public static void main(String[] args) {
        Store store = DbStore.instOf();
        store.save(new Post(0, "Java Job for Junior"));
        store.save(new Post(0, "Java Job for Middle"));
        store.save(new Post(0, "Java Job for Senior"));
        store.save(new Candidate(0, "Junior"));
        store.save(new Candidate(0, "Middle"));
        store.save(new Candidate(0, "Senior"));
        store.deletePost(2);
        store.deleteCandidate(1);
        store.save(new Post(1, "Updated Job for Junior"));
        store.save(new Candidate(3, "Updated Senior"));
        for (Post post : store.findAllPosts()) {
            System.out.println(post.getId() + " " + post.getName());
        }
        for (Candidate candidate : store.findAllCandidates()) {
            System.out.println(candidate.getId() + " " + candidate.getName());
        }
    }
}