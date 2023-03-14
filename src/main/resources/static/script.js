  function playSound() {
    const instrument = document.getElementById('instrument').value;
    const chord = document.getElementById('chord').value;
    
    if (!instrument || !chord) {
      alert('Please select an instrument and a chord');
      return;
    }
    
    const alertBox = document.getElementById('alert');
    alertBox.textContent = `Playing ${chord} chord on ${instrument}`;
    alertBox.style.opacity = 1;
    
    setTimeout(() => {
      alertBox.style.opacity = 0;
    }, 3000);
  }
  
  let darkMode = false;
  function toggleDarkMode() {
    darkMode = !darkMode;
    if (darkMode) {
      document.body.classList.add('dark-mode');
    } else {
      document.body.classList.remove('dark-mode');
    }
  }
  
  const darkModeBtn = document.createElement('button');
  darkModeBtn.textContent = 'Toggle Dark Mode';
  darkModeBtn.addEventListener('click', toggleDarkMode);
  document.body.appendChild(darkModeBtn);



  const alert = document.getElementById('alert');
  const usernameInput = document.getElementById('username');
  const passwordInput = document.getElementById('password');
  const signInButton = document.getElementsByTagName('button')[0];
  const signUpButton = document.getElementsByTagName('button')[1];
  const select = document.getElementById('theme');

  signInButton.addEventListener('click', () => {
  // Handle sign in logic here
  alert.style.opacity = 1;
  setTimeout(() => {
  alert.style.opacity = 0;
}, 3000);
});

  signUpButton.addEventListener('click', () => {
  // Handle sign up logic here
  alert.style.opacity = 1;
  setTimeout(() => {
  alert.style.opacity = 0;
}, 3000);
});

  select.addEventListener('change', () => {
  document.body.className = select.value;
});
