package dream.store;

import dream.model.Candidate;
import org.junit.Assert;
import org.junit.Test;
import dream.model.Post;

import java.util.List;


public class DbStoreTest {
    @Test
    public void whenCreatePost() {
        Store store = DbStore.instOf();
        Post post = new Post(0, "Java Job");
        store.save(post);
        Post postInDb = store.findPostById(post.getId());
        Assert.assertEquals(postInDb.getName(), post.getName());
    }

    @Test
    public void whenCreateCandidate() {
        Store store = DbStore.instOf();
        Candidate candidate = new Candidate(0, "Junior");
        store.save(candidate);
        Candidate candidate1nDb = store.findCandidateById(candidate.getId());
        Assert.assertEquals(candidate1nDb.getName(), candidate.getName());
    }

    @Test
    public void whenUpdatePost() {
        Store store = DbStore.instOf();
        Post post = new Post(0, "Junior job");
        Post updatedJob = new Post(post.getId(), "Updated job");
        store.save(post);
        store.save(updatedJob);
        Post postInDb = store.findPostById(updatedJob.getId());
        Assert.assertEquals(postInDb.getName(), updatedJob.getName());
    }

    @Test
    public void whenUpdateCandidate() {
        Store store = DbStore.instOf();
        Candidate candidate = new Candidate(0, "Junior");
        Candidate updatedCandidate = new Candidate(candidate.getId(), "Updated candidate");
        store.save(candidate);
        store.save(updatedCandidate);
        Candidate candidateInDb = store.findCandidateById(updatedCandidate.getId());
        Assert.assertEquals(candidateInDb.getName(), updatedCandidate.getName());
    }

    @Test
    public void whenDeletePost() {
        Store store = DbStore.instOf();
        Post post = new Post(0, "Job");
        store.save(post);
        Assert.assertEquals(store.findPostById(post.getId()).getName(), post.getName());
        store.deletePost(post.getId());
        Assert.assertNull(store.findPostById(post.getId()));
    }

    @Test
    public void whenDeleteCandidate() {
        Store store = DbStore.instOf();
        Candidate candidate = new Candidate(0, "Junior for delete");
        store.save(candidate);
        Assert.assertEquals(store.findCandidateById(candidate.getId()).getName(), candidate.getName());
        store.deleteCandidate(candidate.getId());
        Assert.assertNull(store.findCandidateById(candidate.getId()));
    }

    @Test
    public void whenFindAllPosts() {
        Store store = DbStore.instOf();
        store.findAllPosts().forEach(post -> store.deletePost(post.getId()));
        Post firstPost = new Post(0, "First Job");
        Post secondPost = new Post(0, "Second Job");
        store.save(firstPost);
        store.save(secondPost);
        Assert.assertEquals(store.findAllPosts(), List.of(firstPost, secondPost));
    }

    @Test
    public void whenFindAllCandidates() {
        Store store = DbStore.instOf();
        store.findAllCandidates().forEach(candidate -> store.deleteCandidate(candidate.getId()));
        Candidate firstCandidate = new Candidate(0, "Junior");
        Candidate secondCandidate = new Candidate(0, "Middle");
        store.save(firstCandidate);
        store.save(secondCandidate);
        Assert.assertEquals(store.findAllCandidates(), List.of(firstCandidate, secondCandidate));
    }
}