package FormBuilderByHackers.Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "form_sessions")
public class FormSessions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "form_session_id")
    private long formSessionId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "formData")
    @OrderBy("attribute_list_details_id ASC")
    private Set<AttributeDataDetails> attributeDataDetailsSet = new HashSet<>();

    @Column(name = "session_name",length = 800)
    private String sessionName;

    @Column(name = "session_order")
    private Integer sessionOrder;

    @Column(name = "created_date", updatable = false)
    private Timestamp createdDate = new Timestamp(new Date().getTime());

    @Column(name = "update_date")
    private Timestamp updatedDate = new Timestamp(new Date().getTime());

}
