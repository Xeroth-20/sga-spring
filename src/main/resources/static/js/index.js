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

const handleAnoEscolarChange = ({ target }) => {
    const gradoSelect = document.querySelector('#grado');
    if (target.value) {
        fetch(`/academico/grados/opciones?ano-escolar-id=${target.value}`, {
            method: 'get'
        }).then((res) => res.text())
            .then((data) => {
                gradoSelect.innerHTML = data;
                gradoSelect.disabled = false;
            });
    } else {
        gradoSelect.disabled = true;
    }
};

const handleGradoChange = ({ target }) => {
    const gradoSelect = document.querySelector('#curso');
    if (target.value) {
        fetch(`/cursopedia/cursos/opciones?grado-id=${target.value}`, {
            method: 'get'
        }).then((res) => res.text())
            .then((data) => {
                gradoSelect.innerHTML = data;
                gradoSelect.disabled = false;
            });
    } else {
        gradoSelect.disabled = true;
    }
};

window.addEventListener('load', () => {
    enableMenuItems();
    enableGoBackBtns();
});


