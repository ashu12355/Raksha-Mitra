document.querySelectorAll('a[href^="#"]').forEach(anchor => {
    anchor.addEventListener('click', function(e) {
        e.preventDefault();

        const target = document.querySelector(this.getAttribute('href'));
        
        window.scrollTo({
            top: target.offsetTop,
            behavior: 'smooth'
        });
    });
});


// Check if the URL contains a query parameter for the section
window.onload = function() {
    const urlParams = new URLSearchParams(window.location.search);
    const section = urlParams.get('section'); // Get the 'section' parameter from the URL

    if (section) {
        // If a section is specified, scroll to that section smoothly
        const target = document.getElementById(section);
        if (target) {
            setTimeout(() => {
                window.scrollTo({
                    top: target.offsetTop,
                    behavior: 'smooth' // Smooth scrolling
                });
            }, 500); // Delay to ensure the page fully loads before scrolling
        }
    }
};

// Smooth scrolling for anchor links within the same page
document.querySelectorAll('a[href^="#"]').forEach(anchor => {
    anchor.addEventListener('click', function(e) {
        e.preventDefault();

        const target = document.querySelector(this.getAttribute('href'));

        window.scrollTo({
            top: target.offsetTop,
            behavior: 'smooth' // Smooth scroll
        });
    });
});



// Function to add/remove the "scrolled" class based on scroll position
window.addEventListener("scroll", function() {
var header = document.querySelector(".header2");

if (window.scrollY > 50) { // Adjust the value based on when you want the border to appear
    header.classList.add("scrolled");
} else {
    header.classList.remove("scrolled");
}
});

