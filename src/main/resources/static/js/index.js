const enableMenuItems = () => {
    const menuItems = document.querySelectorAll('.menu-item[data-toggler="collapse"]');
    menuItems.forEach((menuItem) => {
        const targetId = menuItem.dataset.target;
        const target = document.querySelector(targetId);
        menuItem.addEventListener('click', () => {
            target.classList.toggle('active');
        });
    });
};

const enableGoBackBtns = () => {
    const goBackBtns = document.querySelectorAll('.go-back-btn');
    goBackBtns.forEach((btn) => {
        btn.addEventListener('click', () => {
            window.history.back();
        });
    });
};

const getGradosByAnoEscolarId = ({ target }) => {
    const selectInput = document.querySelector('#grado');
    if (target.value) {
        fetch(`/academico/grados/opciones?ano-escolar-id=${target.value}`, {
            method: 'get'
        }).then((res) => res.text())
            .then((data) => {
                selectInput.innerHTML = data;
                selectInput.disabled = false;
            });
    } else {
        selectInput.disabled = true;
    }
};

const getSeccionesByGradoId = ({ target }) => {
    const selectInput = document.querySelector('#seccion');
    if (target.value) {
        fetch(`/academico/secciones/opciones?grado-id=${target.value}`, {
            method: 'get'
        }).then((res) => res.text())
            .then((data) => {
                selectInput.innerHTML = data;
                selectInput.disabled = false;
            });
    } else {
        selectInput.disabled = true;
    }
};

const getCursosByGradoId = ({ target }) => {
    const selectInput = document.querySelector('#curso');
    if (target.value) {
        fetch(`/cursopedia/cursos/opciones?grado-id=${target.value}`, {
            method: 'get'
        }).then((res) => res.text())
            .then((data) => {
                selectInput.innerHTML = data;
                selectInput.disabled = false;
            });
    } else {
        selectInput.disabled = true;
    }
};

window.addEventListener('load', () => {
    enableMenuItems();
    enableGoBackBtns();
});


