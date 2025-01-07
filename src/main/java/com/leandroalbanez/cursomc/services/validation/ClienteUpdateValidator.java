package com.leandroalbanez.cursomc.services.validation;

import com.leandroalbanez.cursomc.domain.Cliente;
import com.leandroalbanez.cursomc.dto.ClienteDTO;
import com.leandroalbanez.cursomc.repositories.ClienteRepository;
import com.leandroalbanez.cursomc.resources.exception.FieldMessage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClienteUpdateValidator implements ConstraintValidator<ClienteUpdate, ClienteDTO> {

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public void initialize(ClienteUpdate ann) {
    }

    @Override
    public boolean isValid(ClienteDTO objDto, ConstraintValidatorContext context) {
        @SuppressWarnings("unchecked")
        Map<String, String> map = (Map<String, String>) httpServletRequest.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        Integer urlId = Integer.valueOf(map.get("id"));

        List<FieldMessage> list = new ArrayList<>();

        Cliente cliente = clienteRepository.findByEmail(objDto.getEmail());
        if (cliente != null && !cliente.getId().equals(urlId)) {
            list.add(new FieldMessage("email", "E-mail já existente"));
        }
        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName()).addConstraintViolation();
        }
        return list.isEmpty();
    }
}