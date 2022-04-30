<template>
    <div class="backdrop">
        <div class="sample">
            <p>Modal content right here</p>
        </div>
    </div>
</template>

<style>
    .sample {
        width: 400px; 
        padding: 20px; 
        margin: 100px auto; 
        background: white;
    }
    .backdrop {
        top: 0; 
        position: fixed; 
        background: rgba(0, 0, 0, 0.5); 
        width: 100%; 
        height: 100%;
    }
</style>