    package com.example.bank.service;

    import com.example.bank.dto.StatementDTO;
    import com.example.bank.model.AccountModel;
    import com.example.bank.model.StatementModel;
    import com.example.bank.repository.StatementRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import java.sql.PreparedStatement;
    import java.util.ArrayList;
    import java.util.List;

    @Service
    public class StatementService {

        @Autowired
        StatementRepository repository;

        public void saveStatement(StatementModel model) {
            repository.save(model);
        }

        public List<StatementDTO> getStatement(Long acNo) {
            List<StatementModel> models = repository.findAllByAcNo(acNo);
            List<StatementDTO> statement = new ArrayList<>();

            for (StatementModel model : models) {
                StatementDTO st = new StatementDTO();
                st.setType(model.getType());
                st.setAmount(model.getAmount());
                st.setDate(model.getDate());
                statement.add(st);
            }

            return statement;
        }


    }

